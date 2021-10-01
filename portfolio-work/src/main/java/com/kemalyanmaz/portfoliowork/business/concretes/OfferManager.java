package com.kemalyanmaz.portfoliowork.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalyanmaz.portfoliowork.business.abstracts.CurrencyService;
import com.kemalyanmaz.portfoliowork.business.abstracts.CustomerService;
import com.kemalyanmaz.portfoliowork.business.abstracts.EmployeeService;
import com.kemalyanmaz.portfoliowork.business.abstracts.OfferService;
import com.kemalyanmaz.portfoliowork.business.abstracts.ProductService;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.OfferDao;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.OfferDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Currency;
import com.kemalyanmaz.portfoliowork.entities.concretes.Customer;
import com.kemalyanmaz.portfoliowork.entities.concretes.Employee;
import com.kemalyanmaz.portfoliowork.entities.concretes.Offer;
import com.kemalyanmaz.portfoliowork.entities.concretes.Product;

@Service
public class OfferManager implements OfferService{

	private OfferDao offerDao;
	private EmployeeService employeeService;
	private CustomerService customerService;
	private ProductService productService;
	private CurrencyService currencyService;
	
	
	@Autowired
	public OfferManager(OfferDao offerDao, EmployeeService employeeService, CustomerService customerService,
			ProductService productService, CurrencyService currencyService) {
		super();
		this.offerDao = offerDao;
		this.employeeService = employeeService;
		this.customerService = customerService;
		this.productService = productService;
		this.currencyService = currencyService;
	}

	@Override
	public List<OfferDto> getAllOffers() {
		Map<Long,OfferDto> offerMap = new HashMap<>();
		offerDao.findAll().forEach(offer->{
			offerMap.put(offer.getId(),offerToDto(offer));
		});
		
		List<OfferDto> offerList = new ArrayList<>();
		for(long id:offerMap.keySet()) {
			offerList.add(offerMap.get(id));
		}

		return offerList;
	}

	private OfferDto offerToDto(Offer offer) {
		OfferDto offerDto = new OfferDto();
		offerDto.setId(offer.getId());
		offerDto.setTotalPrice(offer.getTotalPrice());
		offerDto.setOfferDate(offer.getOfferDate());
		
		offerDto.setEmployee(employeeService.getById(offer.getEmployeeId()));
		
		offerDto.setCustomer(customerService.getById(offer.getCustomerId()));
		
		offerDto.setProduct(productService.getById(offer.getProductId()));
		
		offerDto.setCurrency(currencyService.getById(offer.getCurrencyId()));
	
		return offerDto;
	}

	@Override
	public Offer addOffer(Offer offer) {
		return offerDao.save(offer);
	}

	@Override
	public OfferDto getById(long id) {
		return offerToDto(offerDao.getById(id));
	}

	@Override
	public boolean existsById(long id) {
		return offerDao.existsById(id);
	}
}
