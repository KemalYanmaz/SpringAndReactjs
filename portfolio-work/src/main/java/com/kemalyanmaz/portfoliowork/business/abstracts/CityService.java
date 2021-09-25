package com.kemalyanmaz.portfoliowork.business.abstracts;

import java.util.List;

import com.kemalyanmaz.portfoliowork.entities.concretes.City;

public interface CityService {

	List<City> getAllCities();
	
	City getCityById(long id);
	
	City addCity(City city);
	
	boolean existsById(long id);
	

}
