package com.kemalyanmaz.portfoliowork.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalyanmaz.portfoliowork.business.abstracts.CityService;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.CityDao;
import com.kemalyanmaz.portfoliowork.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;
	
	public CityManager() {
	}
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public List<City> getAllCities() {
		return cityDao.findAll();
	}

	@Override
	public City getCityById(long id) {
		return cityDao.findById(id).orElse(new City());
	}

	@Override
	public City addCity(City city) {
		return cityDao.save(city);
	}

	@Override
	public boolean existsById(long id) {
		return cityDao.existsById(id);
	}
	
	
}
