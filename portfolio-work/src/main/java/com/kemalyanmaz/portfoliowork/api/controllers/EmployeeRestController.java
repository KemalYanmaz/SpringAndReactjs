package com.kemalyanmaz.portfoliowork.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalyanmaz.portfoliowork.business.abstracts.EmployeeService;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.EmployeeDto;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	public EmployeeRestController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<EmployeeDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getById(@PathVariable("id") long id){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getById(id));
	}
}
