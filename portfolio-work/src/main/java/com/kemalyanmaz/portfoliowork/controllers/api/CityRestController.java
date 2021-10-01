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

import com.kemalyanmaz.portfoliowork.business.abstracts.CityService;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.CityDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CityRestController {

	private CityService cityService;
	
	public CityRestController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping
	public ResponseEntity<List<City>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(cityService.getAllCities());
	}
	
	@PostMapping
	public ResponseEntity<City> add(@RequestBody City city){
		return ResponseEntity.status(HttpStatus.OK).body(cityService.addCity(city));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CityDto> getById(@PathVariable("id") long id){
		return ResponseEntity.status(HttpStatus.OK).body(cityService.getCityById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<City> update(@PathVariable("id") long id,@RequestBody City city){
		return ResponseEntity.status((cityService.existsById(id))?HttpStatus.OK:HttpStatus.CREATED)
				.body(cityService.addCity(city));
	}

}
