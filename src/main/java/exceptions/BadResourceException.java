/**
 * 
 */
package exceptions;

/**
 * @author ganesh
 *
 */
public class BadResourceException extends BusinessException {
	private static final long serialVersionUID = 1L;
	
	protected Class<?> resource;
	protected String identifier;
	
	public BadResourceException(ErrorCode errorCode, Class<?> resource) {
		this(errorCode, resource, "");
	}
	
	public BadResourceException(ErrorCode errorCode, Class<?> resource, String identifer) {
		super(errorCode);
		this.resource = resource;
		this.identifier = identifer;
	}
	
	public BadResourceException(ErrorCode errorCode, String description) {
		super(errorCode, description);
	}
	
	/**
	 * @return the resource
	 */
	public Class<?> getResource() {
		return resource;
	}
}
