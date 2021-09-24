package com.kemalyanmaz.portfoliowork.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalyanmaz.portfoliowork.business.abstracts.OfferService;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.CurrencyDao;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.CustomerDao;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.EmployeeDao;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.OfferDao;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.ProductDao;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.OfferDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Currency;
import com.kemalyanmaz.portfoliowork.entities.concretes.Customer;
import com.kemalyanmaz.portfoliowork.entities.concretes.Employee;
import com.kemalyanmaz.portfoliowork.entities.concretes.Offer;
import com.kemalyanmaz.portfoliowork.entities.concretes.Product;

@Service
public class OfferManager implements OfferService{

	private OfferDao offerDao;
	private EmployeeDao employeeDao;
	private CustomerDao customerDao;
	private ProductDao productDao;
	private CurrencyDao currencyDao;
	
	@Autowired
	public OfferManager(OfferDao offerDao) {
		this.offerDao = offerDao;
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
		
		Employee employee = employeeDao.findById(offer.getEmployeeId()).get();
		offerDto.setEmployeeid(employee.getId());
		offerDto.setEmployeeName(employee.getFullName());
		
		Customer customer = customerDao.findById(offer.getCustomerId()).get();
		offerDto.setCustomerId(customer.getId());
		offerDto.setCustomerName(customer.getFullName());
		offerDto.setCustomerPhone(customer.getPhoneNumber());
		
		Product product = productDao.findById(offer.getProductId()).get();
		offerDto.setProductId(product.getId());
		offerDto.setProductName(product.getProductName());
		offerDto.setProductPrice(product.getProductPrice());
		
		Currency currency = currencyDao.findById(offer.getCurrencyId()).get();
		offerDto.setCurrencyId(currency.getId());
		offerDto.setCurrencyName(currency.getCurrencyName());
		offerDto.setCurrencyValue(currency.getCurrencyValue());
		
		return offerDto;
	}
}
