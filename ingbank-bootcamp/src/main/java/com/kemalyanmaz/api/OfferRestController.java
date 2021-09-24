package com.kemalyanmaz.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalyanmaz.business.OfferService;
import com.kemalyanmaz.data.entities.Offer;

@RestController
@RequestMapping("/api/offers")
public class OfferRestController {
	
	private OfferService offerService;
	
	@Autowired
	public OfferRestController(OfferService offerService) {
		this.offerService = offerService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Offer>> getAllOffers(){
		return ResponseEntity.status(HttpStatus.OK).body(offerService.getAllOffers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Offer> getOfferById(@PathVariable("id") long id){
		return ResponseEntity.status(HttpStatus.OK).body(offerService.getById(id));
	}
}
