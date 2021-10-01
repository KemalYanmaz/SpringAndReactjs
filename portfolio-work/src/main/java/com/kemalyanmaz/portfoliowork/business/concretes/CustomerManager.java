package com.kemalyanmaz.portfoliowork.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalyanmaz.portfoliowork.business.abstracts.AddressService;
import com.kemalyanmaz.portfoliowork.business.abstracts.CustomerService;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.CityDao;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.CustomerDao;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.SectorDao;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.TaxDao;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.AddressDto;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.CustomerDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.City;
import com.kemalyanmaz.portfoliowork.entities.concretes.Customer;
import com.kemalyanmaz.portfoliowork.entities.concretes.Sector;
import com.kemalyanmaz.portfoliowork.entities.concretes.Tax;

@Service
public class CustomerManager implements CustomerService {

	private CustomerDao customerDao;
	private AddressService addressService;
	private CityDao cityDao;
	private TaxDao taxDao;
	private SectorDao sectorDao;
	
	public CustomerManager() {
		
	}
	
	@Autowired
	public CustomerManager(CustomerDao customerDao, AddressService addressService, TaxDao taxDao, SectorDao sectorDao, CityDao cityDao) {
		super();
		this.customerDao = customerDao;
		this.addressService = addressService;
		this.taxDao = taxDao;
		this.sectorDao = sectorDao;
		this.cityDao = cityDao;
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
		
		AddressDto address = addressService.getAddressDtoById(customer.getAddressId());
		
		Tax tax = taxDao.findById(customer.getTaxId()).orElse(new Tax());
		customerDto.setTaxNo(tax.getTaxNumber());
		City city = cityDao.findById(tax.getTaxCityId()).orElse(new City());
		customerDto.setTaxCityName(city.getCityName());
		
		Sector sector = sectorDao.findById(customer.getSectorId()).orElse(new Sector());
		customerDto.setSectorName(sector.getSectorName());
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
