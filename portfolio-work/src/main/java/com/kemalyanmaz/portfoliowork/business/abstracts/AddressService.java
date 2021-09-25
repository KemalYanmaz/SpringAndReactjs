package com.kemalyanmaz.portfoliowork.business.abstracts;

import java.util.List;

import com.kemalyanmaz.portfoliowork.dataAccess.concretes.AddressDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Address;

public interface AddressService {
	
	List<AddressDto> getAll();
	Address addAddress(Address address);
	AddressDto getAddressDtoById(long id);
	boolean existsById(long id);
	

}
