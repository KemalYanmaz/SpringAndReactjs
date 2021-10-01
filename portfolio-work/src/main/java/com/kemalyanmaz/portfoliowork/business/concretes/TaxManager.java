package com.kemalyanmaz.portfoliowork.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalyanmaz.portfoliowork.business.abstracts.CityService;
import com.kemalyanmaz.portfoliowork.business.abstracts.TaxService;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.TaxDao;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.TaxDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Tax;

@Service
public class TaxManager implements TaxService{

	private TaxDao taxDao;
	private CityService cityService;
	
	@Autowired
	public TaxManager(TaxDao taxDao, CityService cityService) {
		this.taxDao = taxDao;
		this.cityService = cityService;
	}

	@Override
	public TaxDto getById(long id) {
		return taxToDto(taxDao.findById(id).orElse(new Tax()));
	}
	
	private TaxDto taxToDto(Tax tax) {
		TaxDto taxDto = new TaxDto();
		taxDto.setCity(cityService.getCityById(tax.getTaxCityId()));
		taxDto.setTaxNumber(tax.getTaxNumber());
		return taxDto;
	}
	
}
