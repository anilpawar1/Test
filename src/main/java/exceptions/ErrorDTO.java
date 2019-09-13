package exceptions;

public class ErrorDTO implements DTO{

	

	private String code;
	private String description;
	private String message;
	
	public enum ErrorCode {
		BAD_REQUEST(4400),
		UNAUTHORIZED(4401),
		FORBIDDEN(4403),
		NOT_FOUND(4404),
		NOTE_NOT_FOUND(44041),
		VEHICLE_NOT_FOUND(44042),
		CONFLICT(4409),
		INTERNAL_SERVER_ERROR(5500);
		
		private int code;
		
		private ErrorCode(int code) {
			this.code = code;
		}
		
		public int getCode() {
			return code;
		}	
	}
	
	public ErrorDTO() {
		super();
	}
	
	public ErrorDTO(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public ErrorDTO(String code, String message, String description) {
		super();
		this.code = code;
		this.message = message;
		this.description = description;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
