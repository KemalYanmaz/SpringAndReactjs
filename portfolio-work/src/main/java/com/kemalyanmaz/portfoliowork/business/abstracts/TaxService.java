package com.kemalyanmaz.portfoliowork.business.abstracts;

import com.kemalyanmaz.portfoliowork.dataAccess.concretes.TaxDto;

public interface TaxService {
	
	TaxDto getById(long id);

}
