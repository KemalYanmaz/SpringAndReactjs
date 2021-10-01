package com.kemalyanmaz.portfoliowork.dataAccess.concretes;

public class TaxDto {
	
	private String tax_number;
	
	private CityDto city;

	public String getTaxNumber() {
		return tax_number;
	}

	public void setTaxNumber(String tax_number) {
		this.tax_number = tax_number;
	}

	public CityDto getCity() {
		return city;
	}

	public void setCity(CityDto city) {
		this.city = city;
	}

}
