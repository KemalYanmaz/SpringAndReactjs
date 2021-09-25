package com.kemalyanmaz.portfoliowork.business.abstracts;

import java.util.List;

import com.kemalyanmaz.portfoliowork.dataAccess.concretes.EmployeeDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Employee;

public interface EmployeeService {
	
	List<EmployeeDto> getAll();

	EmployeeDto getById(long id);
	
	Employee addEmployee(Employee employee);
	
	boolean existsById(long id);
	
}
