package com.kemalyanmaz.portfoliowork.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalyanmaz.portfoliowork.business.abstracts.EmployeeService;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.DepartmentDao;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.EmployeeDao;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.GraduationDao;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.EmployeeDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Department;
import com.kemalyanmaz.portfoliowork.entities.concretes.Employee;
import com.kemalyanmaz.portfoliowork.entities.concretes.Graduation;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeeDao;
	private DepartmentDao departmentDao;
	private GraduationDao graduationDao;
	
	
	public EmployeeManager() {
		super();
	}
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,DepartmentDao departmentDao, GraduationDao graduationDao) {
		super();
		this.employeeDao = employeeDao;
		this.departmentDao = departmentDao;
		this.graduationDao = graduationDao;
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
		
		Department department = departmentDao.findById(employee.getDepartmentId()).orElse(new Department());
		employeer.setDepartmentId(department.getId());
		employeer.setDepartmentName(department.getDepartmentName());
		employeer.setDepartmentSummary(department.getDepartmentSummary());
		
		Graduation graduation = graduationDao.findById(employee.getGraduationID()).orElse(new Graduation());
		employeer.setGraduationId(graduation.getId());
		employeer.setGraduationName(graduation.getGraduationName());
		
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
