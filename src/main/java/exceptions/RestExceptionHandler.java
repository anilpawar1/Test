/**
 * 
 */
package exceptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.validation.Path.Node;
import javax.validation.Path.PropertyNode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import exceptions.BusinessException;
import exceptions.ErrorCode;
import exceptions.IllegalResourceAccessException;
import exceptions.InvalidRequestException;
import exceptions.ResourceNotFoundException;
import util.StringUtils;
import exceptions.ErrorDTO;

/**
 * @author ganesh
 *
 */
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	private Logger logger = LogManager.getLogger(RestExceptionHandler.class);
	
	@Autowired
	private Environment env;
	
	//TODO : also add handler for exception.
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Response> handleBusinessException(BusinessException businessException) {
		logger.debug("Handling business exception : " + businessException.getMessage());
		return new ResponseEntity<Response>(ResponseBuilder.builder()
				.error(new ErrorDTO(businessException.getErrorCode().getCode(), businessException.getErrorCode().name(), "Internal server error"))
				.build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<Response> handleInvalidRequestException(InvalidRequestException invRequestException) {
		logger.debug("Handling invalid request exception : " + invRequestException.getMessage());
		return new ResponseEntity<Response>(ResponseBuilder.builder()
				.error(new ErrorDTO(invRequestException.getErrorCode().getCode(), invRequestException.getErrorCode().name(), invRequestException.getDescription()))
				.build(),
				HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Response> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
		logger.debug("Handling resource not found exception : " + resourceNotFoundException.getMessage());
		ErrorDTO errorDTO = null;
		if (StringUtils.isValidString(resourceNotFoundException.getDescription())) {
			errorDTO = new ErrorDTO(resourceNotFoundException.getErrorCode().getCode(), resourceNotFoundException.getErrorCode().name(),
					resourceNotFoundException.getDescription());
		} else {
			errorDTO = new ErrorDTO(resourceNotFoundException.getErrorCode().getCode(), resourceNotFoundException.getErrorCode().name(),
					String.format(env.getProperty("gt.resource.not.found"), resourceNotFoundException.getResource().getSimpleName(),
							resourceNotFoundException.getIdentifier()));
		}
		return new ResponseEntity<Response>(ResponseBuilder.builder().error(errorDTO).build(), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ExceptionHandler(IllegalResourceAccessException.class)
	public ResponseEntity<Response> handleResourceNotFoundException(IllegalResourceAccessException illegalResourceAccessException) {
		logger.debug("Handling illegal resource not found exception : " + illegalResourceAccessException.getMessage());
		ErrorDTO errorDTO = null;
		if (StringUtils.isValidString(illegalResourceAccessException.getDescription())) {
			errorDTO = new ErrorDTO(illegalResourceAccessException.getErrorCode().getCode(), illegalResourceAccessException.getErrorCode().name(),
					illegalResourceAccessException.getDescription());
		} else {
			errorDTO = new ErrorDTO(illegalResourceAccessException.getErrorCode().getCode(), illegalResourceAccessException.getErrorCode().name(),
					String.format(env.getProperty("gt.resource.not.accessible"), illegalResourceAccessException.getResource().getSimpleName(),
							illegalResourceAccessException.getIdentifier()));
		}
		return new ResponseEntity<Response>(ResponseBuilder.builder().error(errorDTO).build(),HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException
			, HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.debug("Handling method argument not valid exception : " + methodArgumentNotValidException.getMessage());
		List<ErrorDTO> errorDTOs = new ArrayList<ErrorDTO>();
		List<ObjectError> errors = methodArgumentNotValidException.getBindingResult().getAllErrors();
		
		List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			errorDTOs.add(new ErrorDTO(ErrorCode.INVALID_PARAMTER.getCode(), ErrorCode.INVALID_PARAMTER.name(), fieldError.getField() + " " 
						+ fieldError.getDefaultMessage()));	
		}
		
		return new ResponseEntity(ResponseBuilder.builder().errors(errorDTOs).build(),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> handleConstraintViolationException(ConstraintViolationException constraintViolationException) {
		logger.debug("Handling method argument not valid exception : " + constraintViolationException.getMessage());
		List<ErrorDTO> errorDTOs = new ArrayList<ErrorDTO>();
		Iterator<ConstraintViolation<?>> itr = constraintViolationException.getConstraintViolations().iterator();
		while(itr.hasNext()) {
			ConstraintViolation<?> cv = itr.next();
			String description = getProperty(cv.getPropertyPath()) + " " + cv.getMessage();
			errorDTOs.add(new ErrorDTO(ErrorCode.INVALID_PARAMTER.getCode(), ErrorCode.INVALID_PARAMTER.name(),description));
		}
		return new ResponseEntity<Response>(ResponseBuilder.builder().errors(errorDTOs).build(),HttpStatus.BAD_REQUEST);
	}
	
	private String getProperty(Path path) {
		Iterator<Node> iterator = path.iterator();
		String property = "";
		while (iterator.hasNext()) {
			Node node = iterator.next();
			if (node instanceof PropertyNode) {
				property = node.getName();
			}
		}
		return property;
	}
}