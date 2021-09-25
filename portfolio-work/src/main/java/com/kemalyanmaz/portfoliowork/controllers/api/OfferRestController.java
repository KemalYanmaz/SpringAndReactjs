package com.kemalyanmaz.portfoliowork.controllers.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalyanmaz.portfoliowork.business.abstracts.OfferService;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.OfferDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Offer;

@RestController
@RequestMapping("/api/offers")
public class OfferRestController {
	
	private final OfferService offerService;
	
	public OfferRestController(OfferService offerService) {
		super();
		this.offerService = offerService;
	}
	@GetMapping
	public ResponseEntity<List<OfferDto>> getAllOffers(){
		return ResponseEntity.status(HttpStatus.OK).body(offerService.getAllOffers());
	}
	
	@PostMapping
	public ResponseEntity<Offer> add(@RequestBody Offer offer){
		return ResponseEntity.status(HttpStatus.OK).body(offerService.addOffer(offer));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OfferDto> getOfferById(@PathVariable("id") long id){
		return ResponseEntity.status(HttpStatus.OK).body(offerService.getById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Offer> update(@PathVariable("id") long id,@RequestBody Offer offer){
		return ResponseEntity.status((offerService.existsById(id))?HttpStatus.OK:HttpStatus.CREATED).body(offer);
	}
}
