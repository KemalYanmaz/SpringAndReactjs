package com.kemalyanmaz.portfoliowork.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.kemalyanmaz.portfoliowork.dataAccess.concretes.DepartmentDto;

public interface DepartmentService {
	
	List<DepartmentDto> getAll();
	
	DepartmentDto getById(long id);

}
