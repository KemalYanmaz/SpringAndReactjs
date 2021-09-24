package com.kemalyanmaz.portfoliowork.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalyanmaz.portfoliowork.business.abstracts.OfferService;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.OfferDto;

@RestController
@RequestMapping("/api/offer")
public class OfferRestController {
	
	private OfferService offerService;
	
	@GetMapping("")
	public ResponseEntity<List<OfferDto>> getAllOffers(){
		return ResponseEntity.status(HttpStatus.OK).body(offerService.getAllOffers());
	}

}
