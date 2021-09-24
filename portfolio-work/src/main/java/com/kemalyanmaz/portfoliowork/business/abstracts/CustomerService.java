package com.kemalyanmaz.portfoliowork.business.abstracts;

import java.util.List;

import com.kemalyanmaz.portfoliowork.dataAccess.concretes.CustomerDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Customer;

public interface CustomerService {

	List<CustomerDto> getAll();
	CustomerDto getById(long id);
	Customer addCustomer(Customer customer);
	
}
