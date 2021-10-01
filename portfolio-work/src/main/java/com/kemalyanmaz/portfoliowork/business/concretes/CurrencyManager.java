package com.kemalyanmaz.portfoliowork.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalyanmaz.portfoliowork.business.abstracts.CurrencyService;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.CurrencyDao;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.CurrencyDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Currency;

@Service
public class CurrencyManager implements CurrencyService{
	
	private CurrencyDao currencyDao;
	
	@Autowired
	public CurrencyManager(CurrencyDao currencyDao) {
		this.currencyDao = currencyDao;
	}
	
	@Override
	public List<CurrencyDto> getAll() {
		Map<Long,CurrencyDto> currencyDtoMap = new HashMap<>();
		currencyDao.findAll().forEach(currency->{
			currencyDtoMap.put(currency.getId(), currencyToDto(currency));
		});
		List<CurrencyDto> currencyDtoList = new ArrayList<>();
		for(long id:currencyDtoMap.keySet()) {
			currencyDtoList.add(currencyDtoMap.get(id));
		}
		return currencyDtoList;
	}

	private CurrencyDto currencyToDto(Currency currency) {
		CurrencyDto currencyDto = new CurrencyDto();
		currencyDto.setCurrencyName(currency.getCurrencyName());
		currencyDto.setCurrencyValue(currency.getCurrencyValue());
		return currencyDto;
	}
	
}
