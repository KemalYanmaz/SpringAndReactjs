package com.kemalyanmaz.portfoliowork.controllers.api;

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

import com.kemalyanmaz.portfoliowork.business.abstracts.AddressService;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.AddressDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Address;

@RestController
@RequestMapping("/api/addresses")
public class AddressRestController {

	private final AddressService addressService;
	
	public AddressRestController(AddressService addressService) {
		
		this.addressService = addressService;
	}
	
	@GetMapping
	public ResponseEntity<List<AddressDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(addressService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Address> add(@RequestBody Address address){
		return ResponseEntity.status(HttpStatus.OK).body(addressService.addAddress(address));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AddressDto> getById(@PathVariable("id") long id){
		return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddressDtoById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Address> update(@PathVariable("id") long id,@RequestBody Address address){
		return ResponseEntity.status((addressService.existsById(id))?HttpStatus.OK:HttpStatus.CREATED)
				.body(addressService.addAddress(address));
	}
}
