package com.kemalyanmaz.portfoliowork.business.abstracts;

import java.util.List;

import com.kemalyanmaz.portfoliowork.dataAccess.concretes.OfferDto;

public interface OfferService {
	
	List<OfferDto> getAllOffers();
	

}
