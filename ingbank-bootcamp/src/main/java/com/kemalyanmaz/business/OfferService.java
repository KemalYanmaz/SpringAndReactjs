package com.kemalyanmaz.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalyanmaz.data.entities.Offer;
import com.kemalyanmaz.data.repositories.OfferRepository;

@Service
public class OfferService {
	
	
	private final OfferRepository offerRepository;
	
	@Autowired
	public OfferService(OfferRepository offerRepository) {
		this.offerRepository = offerRepository;
	}
	
	public List<Offer> getAllOffers(){
		return offerRepository.findAll();
	}

	public Offer getById(long id) {
		return offerRepository.findById(id).get();
	}
}
