package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.dataAccess.concretes.CountryDto;
import com.example.demo.entities.concretes.Country;

public interface CountryService {
	
	List<CountryDto> findByCapitalLike(String capital);
	
	void add(Country country);
	
	void addAll(List<Country> countries);
	
	List<CountryDto> getAll(String text);

}
