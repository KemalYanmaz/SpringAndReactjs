package com.kemalyanmaz.portfoliowork.business.abstracts;

import java.util.List;

import com.kemalyanmaz.portfoliowork.dataAccess.concretes.CurrencyDto;

public interface CurrencyService {

	List<CurrencyDto> getAll();
	
	CurrencyDto getById(long id);
}
