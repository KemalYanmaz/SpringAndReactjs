package com.kemalyanmaz.portfoliowork.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalyanmaz.portfoliowork.business.abstracts.EmployeeService;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.EmployeeDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

	private final EmployeeService employeeService;
	
	public EmployeeRestController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Employee> add(@RequestBody Employee employee){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.addEmployee(employee));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getById(@PathVariable("id") long id){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> update(@PathVariable("id") long id,@RequestBody Employee employee){
		return ResponseEntity.status((employeeService.existsById(id))?HttpStatus.OK:HttpStatus.CREATED)
				.body(employeeService.addEmployee(employee));
	}
}
