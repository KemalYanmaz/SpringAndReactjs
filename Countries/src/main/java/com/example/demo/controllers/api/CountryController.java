package com.example.demo.controllers.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.CountryService;
import com.example.demo.dataAccess.concretes.CountryDto;
import com.example.demo.entities.concretes.Country;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("api/countries")
public class CountryController {
	
	CountryService countryService;
	
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<CountryDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(countryService.getAll(""));
	}
	
	@GetMapping("/capital/{capital}")
	public ResponseEntity<List<CountryDto>> getByName(@PathVariable("capital") String capital){
		return ResponseEntity.status(HttpStatus.OK).body(countryService.findByCapitalLike(capital));
	}
	
	@GetMapping("/search/{text}")
	public ResponseEntity<List<CountryDto>> getAll(@PathVariable("text") String text){
		return ResponseEntity.status(HttpStatus.OK).body(countryService.getAll(text));
		
	}
	
	@PostMapping
	public ResponseEntity<String> add(@RequestBody Country country){
		countryService.add(country);
		return ResponseEntity.status(HttpStatus.CREATED).body("Eklendi");
	}

}
