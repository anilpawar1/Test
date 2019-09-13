/**
 * 
 */
package exceptions;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.ThreadContext;


/**
 * @author ganesh
 *
 */
public class ResponseBuilder {
	private List<Object> results = new ArrayList<Object>();
	private String message;
	private List<DTO> errors = new ArrayList<DTO>();
	
	private ResponseBuilder() {}
	
	public static ResponseBuilder builder() {
		return new ResponseBuilder();
	}
	
	public ResponseBuilder results(List<?> results) {
		if (results != null) {
			this.results.addAll(results);
		}
		return this;
	}
	
	public ResponseBuilder result(Object result) {
		if (results != null) {
			this.results.add(result);
		}
		return this;
	}
	
	public ResponseBuilder message(String message) {
		this.message = message;
		return this;
	}
	
	public ResponseBuilder errors(List<ErrorDTO> errors) {
		if (errors != null) {
			this.errors.addAll(errors);
		}
		return this;
	}
	
	public ResponseBuilder error(ErrorDTO error) {
		if (errors != null) {
			this.errors.add(error);
		}
		return this;
	}
	
	public Response build() {
		DataDTO dataDTO = new DataDTO();
		dataDTO.setMessage(message);
		dataDTO.setResults(results);
		
		MetaDTO metaDTO = new MetaDTO();
		metaDTO.setTimestamp(System.currentTimeMillis());
		metaDTO.setPath(ThreadContext.get("x-api"));
		Response response = new ResponseImpl();
		response.setData(dataDTO);
		response.setErrors(errors);
		response.setMeta(metaDTO);
		
		return response;
	}
}
