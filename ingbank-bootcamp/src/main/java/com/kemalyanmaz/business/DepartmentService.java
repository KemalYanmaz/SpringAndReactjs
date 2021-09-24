package com.kemalyanmaz.business;

import org.springframework.stereotype.Service;

import com.kemalyanmaz.data.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	private final DepartmentRepository departmentRepository;
	
	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
}
