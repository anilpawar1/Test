package endpoints;

//import java.util.List;
//import java.util.Optional;

//import javax.websocket.server.PathParam;
import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
///import org.springframework.web.bind.annotation.RequestParam;

import test.Employee;

public interface EmpResource {

public static final String RESOURCE_PATH = "test/v1/emp";
	
	public static final String ALL_PATH = "/all";
	public static final String LATEST_PATH = "/latest";
	public static final String LASTNAME_PATH = "/lastName";
	public static final String ID_PATH = "/{id}";
		
	/*@RequestMapping(method = RequestMethod.GET, path = {
					ALL_PATH }, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAll();
	
	@RequestMapping(method = RequestMethod.GET, path = {
			LASTNAME_PATH }, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByLastName( @RequestParam(value = "lastName") String lastName );
	
	@RequestMapping(method = RequestMethod.GET, path = {
			ID_PATH }, produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Employee> findById( @PathVariable("id") Integer id );
	*/
	@RequestMapping(method = RequestMethod.POST, path = {}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee addEmployee(@RequestBody Employee emp);
	
}
