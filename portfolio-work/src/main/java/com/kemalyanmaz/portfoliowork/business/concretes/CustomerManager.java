package com.kemalyanmaz.portfoliowork.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalyanmaz.portfoliowork.business.abstracts.AddressService;
import com.kemalyanmaz.portfoliowork.business.abstracts.CityService;
import com.kemalyanmaz.portfoliowork.business.abstracts.CustomerService;
import com.kemalyanmaz.portfoliowork.business.abstracts.SectorService;
import com.kemalyanmaz.portfoliowork.business.abstracts.TaxService;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.CustomerDao;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.AddressDto;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.CustomerDto;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.SectorDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Customer;

@Service
public class CustomerManager implements CustomerService {

	private CustomerDao customerDao;
	private AddressService addressService;
	private TaxService taxService;
	private SectorService sectorService;
	
	public CustomerManager() {
		
	}
	
	@Autowired
	public CustomerManager(CustomerDao customerDao, AddressService addressService, TaxService taxService, SectorService sectorService) {
		super();
		this.customerDao = customerDao;
		this.addressService = addressService;
		this.taxService = taxService;
		this.sectorService = sectorService;
	}


	@Override
	public List<CustomerDto> getAll() {
		Map<Long,CustomerDto> customerMap = new HashMap<>();
		customerDao.findAll().forEach(customer->{
			CustomerDto customerDto = customerToDto(customer);
			customerMap.put(customerDto.getId(),customerDto);
		});
		List<CustomerDto> customerList = new ArrayList<>();
		for(long id:customerMap.keySet()) {
			customerList.add(customerMap.get(id));
		}
		return customerList;
	}

	@Override
	public CustomerDto getById(long id) {
		return customerToDto(customerDao.findById(id).orElse(new Customer()));
	}

	private CustomerDto customerToDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setId(customer.getId());
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setPhoneNumber(customer.getPhoneNumber());
		
		customerDto.setAddress(addressService.getAddressDtoById(customer.getAddressId()));
		
		customerDto.setTax(taxService.getById(customer.getTaxId()));
		
		customerDto.setSector(sectorService.getById(customer.getSectorId()));
		
		return customerDto;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public boolean existsById(long id) {
		return customerDao.existsById(id);
	}
	
}
