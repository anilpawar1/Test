/**
 * 
 */
package exceptions;

/**
 * @author ganesh
 *
 */
public class MetaDTO implements DTO {
	private static final long serialVersionUID = 1L;
	
	private long timestamp;
	private String path;
	
	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}
	
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
}
