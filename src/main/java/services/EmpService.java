package services;

import java.util.List;
import java.util.Optional;

import test.Employee;

public interface EmpService {

	List<Employee> findByLastName(String lastName);
	Optional<Employee> findById(Integer id);
	List<Employee> findAll();
	Employee save(Employee emp);
}
