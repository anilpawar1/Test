package services.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import test.Employee;

public interface EmpRepository extends CrudRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {

	List<Employee> findByLastName(String lastName);
	Optional<Employee> findById(Integer id);
	List<Employee> findAll();
	<S extends Employee> S save(S employee);
	
}
