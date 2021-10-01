package com.kemalyanmaz.portfoliowork.dataAccess.concretes;

import com.kemalyanmaz.portfoliowork.entities.concretes.Sector;

public class CustomerDto {
	
	private long id;
	private String firstName;
	private String lastName;
	private AddressDto address;
	private String phoneNumber;
	private TaxDto tax;
	private SectorDto sector;
	
	public long getId() {
		return id;
	}
	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public TaxDto getTax() {
		return tax;
	}
	public void setTax(TaxDto tax) {
		this.tax = tax;
	}
	public SectorDto getSector() {
		return sector;
	}
	public void setSector(SectorDto sector) {
		this.sector = sector;
	}

	
	
}
