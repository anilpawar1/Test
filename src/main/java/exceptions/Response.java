/**
 * 
 */
package exceptions;

import java.io.Serializable;
import java.util.List;



/**
 * @author ganesh
 *
 */
public interface Response extends Serializable {
	/**
	 * @return the data
	 */
	public DTO getData();
	
	/**
	 * @param data the data to set
	 */
	public void setData(DTO data) ;
	
	/**
	 * @return the error
	 */
	public List<DTO> getErrors() ;
	
	/**
	 * @param error the error to set
	 */
	public void setErrors(List<DTO> error) ;
	
	/**
	 * @return the meta
	 */
	public DTO getMeta() ;
	
	/**
	 * @param meta the meta to set
	 */
	public void setMeta(DTO meta) ;
}
