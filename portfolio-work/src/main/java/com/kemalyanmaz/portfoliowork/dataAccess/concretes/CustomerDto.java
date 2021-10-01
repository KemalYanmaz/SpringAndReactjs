package com.kemalyanmaz.portfoliowork.dataAccess.concretes;

public class CustomerDto {
	
	private long id;
	private String firstName;
	private String lastName;
	private AddressDto address;
	private String phoneNumber;
	private String taxNo;
	private String taxCityName; 
	private String sectorName;
	
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
	public String getTaxNo() {
		return taxNo;
	}
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
	public String getTaxCityName() {
		return taxCityName;
	}
	public void setTaxCityName(String taxCityName) {
		this.taxCityName = taxCityName;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	
	
}
