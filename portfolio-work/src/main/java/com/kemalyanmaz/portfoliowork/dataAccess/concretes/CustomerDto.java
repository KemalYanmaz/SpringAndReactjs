package com.kemalyanmaz.portfoliowork.dataAccess.concretes;

public class CustomerDto {
	
	private long id;
	private String firstName;
	private String lastName;
	private long addressId;
	private long cityId;
	private String cityName;
	private String district;
	private String neighborhood;
	private int doorNo;
	private int floor;
	private String phoneNumber;
	private long taxId;
	private String taxNo;
	private long taxCityId;
	private String taxCityName; 
	private long sectorId;
	private String sectorName;
	
	public long getId() {
		return id;
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
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public int getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long getTaxId() {
		return taxId;
	}
	public void setTaxId(long taxId) {
		this.taxId = taxId;
	}
	public String getTaxNo() {
		return taxNo;
	}
	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
	public long getTaxCityId() {
		return taxCityId;
	}
	public void setTaxCityId(long taxCityId) {
		this.taxCityId = taxCityId;
	}
	public String getTaxCityName() {
		return taxCityName;
	}
	public void setTaxCityName(String taxCityName) {
		this.taxCityName = taxCityName;
	}
	public long getSectorId() {
		return sectorId;
	}
	public void setSectorId(long sectorId) {
		this.sectorId = sectorId;
	}
	public String getSectorName() {
		return sectorName;
	}
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}
	
	
}
