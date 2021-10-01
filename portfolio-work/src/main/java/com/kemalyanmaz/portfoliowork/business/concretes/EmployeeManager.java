package com.kemalyanmaz.portfoliowork.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalyanmaz.portfoliowork.business.abstracts.DepartmentService;
import com.kemalyanmaz.portfoliowork.business.abstracts.EmployeeService;
import com.kemalyanmaz.portfoliowork.business.abstracts.GraduationService;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.EmployeeDao;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.DepartmentDto;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.EmployeeDto;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.GraduationDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeeDao;
	private DepartmentService departmentService;
	private GraduationService graduationService;
	
	
	public EmployeeManager() {
		super();
	}
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,DepartmentService departmentService, GraduationService graduationService) {
		super();
		this.employeeDao = employeeDao;
		this.departmentService = departmentService;
		this.graduationService = graduationService;
	}
	@Override
	public List<EmployeeDto> getAll() {
		Map<Long,EmployeeDto> employeeMap = new HashMap<>();
		employeeDao.findAll().forEach(employee->{
			EmployeeDto employeer = EmployeeToDto(employee);
			employeeMap.put(employeer.getId(), employeer);
		});
		List<EmployeeDto> employees = new ArrayList<>();
		for(Long id:employeeMap.keySet()) {
			employees.add(employeeMap.get(id));
		}
		
		return employees;
	}
	
	@Override
	public EmployeeDto getById(long id) {
		return EmployeeToDto(employeeDao.findById(id).orElse(new Employee()));
	}
	
	
	private EmployeeDto EmployeeToDto(Employee employee) {
		EmployeeDto employeer = new EmployeeDto();
		employeer.setId(employee.getId());
		employeer.setFirstName(employee.getFirstName());
		employeer.setLastName(employee.getLastName());
		employeer.setSalary(employee.getSalary());
		employeer.setJoiningDate(employee.getJoiningDate());
		
		DepartmentDto departmentDto = departmentService.getById(employee.getDepartmentId());
		employeer.setDepartment(departmentDto);
		
		GraduationDto graduation = graduationService.getById(employee.getGraduationID());
		employeer.setGraduation(graduation);
		
		return employeer;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		employeeDao.save(employee);
		return employee;
	}

	@Override
	public boolean existsById(long id) {
		return employeeDao.existsById(id);
	}
	
	

}
