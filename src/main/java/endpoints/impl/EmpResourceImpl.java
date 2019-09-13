package endpoints.impl;

// import java.util.ArrayList;
import java.util.List;
// import java.util.Optional;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
// import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// import endpoints.response.ResponseBuilder;
import services.EmpService;
import endpoints.EmpResource;
import exceptions.BadResourceException;
import test.Employee;


@RestController
@RequestMapping(path = EmpResource.RESOURCE_PATH)
@Validated
public class EmpResourceImpl implements EmpResource{

	@Autowired EmpService empService;

	/*public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return empService.findAll();
	}

	public List<Employee> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		if(true){
			throw new BadResourceException(exceptions.ErrorCode.RESOURCE_NOT_FOUND, "Driver duty not found!");
		}
		return empService.findByLastName(lastName);
	}

	public Optional<Employee> findById(@PathVariable Integer id) {
		
		return empService.findById(id);
	}*/

	@RequestMapping(path = "/add")
	@Override
	public Employee addEmployee(@RequestBody Employee emp) {

		return empService.save(emp);
	}
	

    
    
	/*@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return empService.findAll();
	}

	@Override
	public List<Employee> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return empService.findByLastName(lastName);
	}

	@Override
	public List<Employee> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*public List<Employee> getAll() {
		// TODO Auto-generated method stub
		
		return empService.findAll();
	}

	public List<Employee> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return empService.findByLastName(lastName);
	}

	public List<Employee> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	/*public List<Employee> getAll() {
		return empService.findAll();
	}
	
	@RequestMapping(path = "/lastName")
	public List<Employee> getByLastName(String lastName) {
		return empService.findByLastName(lastName);
	}
	
	@RequestMapping(path = "/id")
	public Optional<Employee> getById(Integer id) {
		return empService.findById(id);
	}*/
	
	
	
}
