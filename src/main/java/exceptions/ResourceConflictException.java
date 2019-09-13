package exceptions;

public class ResourceConflictException extends BusinessException {
	private static final long serialVersionUID = 1L;
	
	protected Class<?> resource;
	protected String identifier;
	
	public ResourceConflictException(ErrorCode errorCode, Class<?> resource, String identifier) {
		super(errorCode);
		this.resource = resource;
		this.identifier = identifier;
	}
	
	public ResourceConflictException(ErrorCode errorCode, String description) {
		super(errorCode, description);
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
}
