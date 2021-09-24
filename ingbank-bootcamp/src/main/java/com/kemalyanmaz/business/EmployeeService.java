package com.kemalyanmaz.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalyanmaz.data.entities.Employee;
import com.kemalyanmaz.data.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}
	
	public Employee getById(long id) {
		return employeeRepository.findById(id).get();
	}
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
}
