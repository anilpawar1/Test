/**
 * 
 */
package exceptions;

/**
 * @author ganesh
 *
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	protected String description; 
	protected ErrorCode errorCode;
	
	public BusinessException(ErrorCode errorCode) {
		this(errorCode, null);
	}
	
	public BusinessException(ErrorCode errorCode, String description) {
		super(errorCode.name());
		this.errorCode = errorCode;
		this.description = description;
	}
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	
	public String getDescription() {
		return description;
	}
}
