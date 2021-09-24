package com.kemalyanmaz.portfoliowork.business.abstracts;

import java.util.List;

import com.kemalyanmaz.portfoliowork.dataAccess.concretes.EmployeeDto;

public interface EmployeeService {
	
	List<EmployeeDto> getAll();

	EmployeeDto getById(long id);
}
