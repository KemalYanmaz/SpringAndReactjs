package com.kemalyanmaz.portfoliowork.business.concretes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalyanmaz.portfoliowork.business.abstracts.AddressService;
import com.kemalyanmaz.portfoliowork.business.abstracts.CityService;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.AddressDao;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.AddressDto;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.CityDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Address;

@Service
public class AddressManager implements AddressService{

	private AddressDao addressDao;
	private CityService cityService;
	
	
	@Autowired
	public AddressManager(AddressDao addressDao, CityService cityService) {
		super();
		this.addressDao = addressDao;
		this.cityService = cityService;
	}


	@Override
	public List<AddressDto> getAll() {
		Map<Long,AddressDto> addressMap = new HashMap<>();
		addressDao.findAll().forEach(address->{
			addressMap.put(address.getId(), addressToDto(address));
		});
		
		List<AddressDto> addressList = new ArrayList<>();
		for(long id:addressMap.keySet()) {
			addressList.add(addressMap.get(id));
		}
		return addressList;
	}
	
	
	private AddressDto addressToDto(Address address) {
		AddressDto addressDto = new AddressDto();
		addressDto.setDistrict(address.getDistrict());
		addressDto.setNeighborhood(address.getNeigborhood());
		addressDto.setDoorNo(address.getDoorNo());
		addressDto.setFloor(address.getFloor());
		addressDto.setCity(cityService.getCityById(address.getCityId()));
		return addressDto;
	}

	@Override
	public Address addAddress(Address address) {
		return addressDao.save(address);
	}

	@Override
	public AddressDto getAddressDtoById(long id) {
		return addressToDto(addressDao.findById(id).orElse(new Address()));
	}


	@Override
	public boolean existsById(long id) {
		return addressDao.existsById(id);
	}
	
	
	
	
	
}
