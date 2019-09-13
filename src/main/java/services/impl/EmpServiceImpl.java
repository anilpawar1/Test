package services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import exceptions.BadResourceException;
import exceptions.ErrorCode;
import services.EmpService;
import services.repository.EmpRepository;
import test.Employee;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired EmpRepository empRepository;
	
	public List<Employee> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		if(true){
			throw new BadResourceException(ErrorCode.RESOURCE_NOT_FOUND, "not found!");
		}
		return empRepository.findByLastName(lastName);
	}
	
	public Optional<Employee> findById(@PathVariable Integer id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		return empRepository.findById(id);
	}

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		//if(empRepository.findAll()!=null && !empRepository.findAll().isEmpty()){
		return empRepository.findAll();
		//}//else
			//throw new 
		
		//return null;
	}

	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		return empRepository.save(emp);
	}
	
}
