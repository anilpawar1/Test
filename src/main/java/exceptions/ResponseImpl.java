/**
 * 
 */
package exceptions;

import java.util.List;



/**
 * @author ganesh
 *
 */
public class ResponseImpl implements Response {
	private static final long serialVersionUID = 1L;

	private DTO data;
	private List<DTO> errors;
	private DTO meta;
	
	/**
	 * @return the data
	 */
	public DTO getData() {
		return data;
	}
	
	/**
	 * @param data the data to set
	 */
	public void setData(DTO data) {
		this.data = data;
	}
	
	/**
	 * @return the error
	 */
	public List<DTO> getErrors() {
		return errors;
	}
	
	/**
	 * @param error the error to set
	 */
	public void setErrors(List<DTO> errors) {
		this.errors = errors;
	}
	
	/**
	 * @return the meta
	 */
	public DTO getMeta() {
		return meta;
	}
	
	/**
	 * @param meta the meta to set
	 */
	public void setMeta(DTO meta) {
		this.meta = meta;
	}
}
