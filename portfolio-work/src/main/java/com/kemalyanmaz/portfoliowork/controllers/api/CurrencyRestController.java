package com.kemalyanmaz.portfoliowork.controllers.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalyanmaz.portfoliowork.business.abstracts.CurrencyService;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.CurrencyDto;

@RestController
@RequestMapping(path="/api/currencies")
public class CurrencyRestController {

	private CurrencyService currencyService;
	
	public CurrencyRestController(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}
	
	@GetMapping()
	public ResponseEntity<List<CurrencyDto>> getAllCurrencies(){
		return ResponseEntity.status(HttpStatus.OK).body(currencyService.getAll());
	}
}
