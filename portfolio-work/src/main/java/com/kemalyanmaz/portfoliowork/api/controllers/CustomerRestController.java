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

import com.kemalyanmaz.portfoliowork.business.abstracts.CustomerService;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.CustomerDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Customer;

@RestController
@RequestMapping(path="/api/customers")
public class CustomerRestController {

	private final CustomerService customerService;
	
	public CustomerRestController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping
	public ResponseEntity<List<CustomerDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Customer> add(@RequestBody Customer customer){
		return ResponseEntity.status(HttpStatus.OK).body(customerService.addCustomer(customer));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> getById(@PathVariable("id") long id){
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getById(id));
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<Customer> update(@PathVariable("id") long id,@RequestBody Customer customer){
			return ResponseEntity.status((customerService.existsById(id))?HttpStatus.OK:HttpStatus.CREATED)
					.body(customerService.addCustomer(customer));
	}
}
