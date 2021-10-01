package com.kemalyanmaz.portfoliowork.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalyanmaz.portfoliowork.business.abstracts.DepartmentService;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.DepartmentDao;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.DepartmentDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService{
	
	private DepartmentDao departmentDao;
	
	@Autowired
	public DepartmentManager(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public List<DepartmentDto> getAll() {
		Map<Long,DepartmentDto> departmentDtoMap = new HashMap<>();
		departmentDao.findAll().forEach(department->{
			departmentDtoMap.put(department.getId(), departmentToDto(department));
		});
		List<DepartmentDto> departmentDtoList = new ArrayList<>();
		
		for(long id:departmentDtoMap.keySet()) {
			departmentDtoList.add(departmentDtoMap.get(id));
		}
		
		return departmentDtoList;
		
	}
	
	private DepartmentDto departmentToDto(Department department) {
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartment_name(department.getDepartmentName());
		departmentDto.setDepartment_summary(department.getDepartmentSummary());
		return departmentDto;
	}

	@Override
	public DepartmentDto getById(long id) {
		return departmentToDto(departmentDao.findById(id).orElse(new Department()));
	}
	
}
