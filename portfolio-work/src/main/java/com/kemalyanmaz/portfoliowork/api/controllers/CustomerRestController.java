package com.kemalyanmaz.portfoliowork.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalyanmaz.portfoliowork.business.abstracts.CustomerService;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.CustomerDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Customer;

@RestController
@RequestMapping(path="/api/customer")
public class CustomerRestController {

	private CustomerService customerService;
	
	public CustomerRestController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<CustomerDto>> getAllCustomers(){
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> getById(@PathVariable("id") long id){
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getById(id));
	}

	@PostMapping(path="/add",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addCustomer(customer));
	}
}
