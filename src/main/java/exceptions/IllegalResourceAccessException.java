/**
 * 
 */
package exceptions;

/**
 * @author ganesh
 *
 */
public class IllegalResourceAccessException extends BusinessException {
	private static final long serialVersionUID = 1L;
	
	protected Class<?> resource;
	protected String identifier;
	protected String user;
	
	public IllegalResourceAccessException(ErrorCode errorCode, String description) {
		super(errorCode, description);
	}
	
	public IllegalResourceAccessException(ErrorCode errorCode, String user, Class<?> resource, String identifier) {
		super(errorCode);
		this.resource = resource;
		this.identifier = identifier;
		this.user = user;
	}
	
	/**
	 * @return the resource
	 */
	public Class<?> getResource() {
		return resource;
	}
	
	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}
	
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}
}
