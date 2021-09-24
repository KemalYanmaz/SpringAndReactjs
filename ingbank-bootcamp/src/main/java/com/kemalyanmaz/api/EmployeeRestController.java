package com.kemalyanmaz.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalyanmaz.business.DepartmentService;
import com.kemalyanmaz.business.EmployeeService;
import com.kemalyanmaz.data.entities.Employee;

@RestController
@RequestMapping(path="/api/employees")
public class EmployeeRestController {

	private final EmployeeService employeeService;
	private final DepartmentService departmentService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService,DepartmentService departmentService) {
		this.employeeService = employeeService;
		this.departmentService = departmentService;
	}
	
	@GetMapping(path="")
	public ResponseEntity<List<Employee>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Employee> getById(@PathVariable("id") long id){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getById(id));
	}
	
	@PostMapping(path="/add",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(employee));
	}
	

}
