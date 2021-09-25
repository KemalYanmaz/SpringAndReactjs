package com.kemalyanmaz.portfoliowork.business.abstracts;

import java.util.List;

import com.kemalyanmaz.portfoliowork.dataAccess.concretes.OfferDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Offer;

public interface OfferService {
	
	List<OfferDto> getAllOffers();
	
	Offer addOffer(Offer offer);
	
	OfferDto getById(long id);
	
	boolean existsById(long id);

}
