package com.kemalyanmaz.portfoliowork.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tax_administration")
public class Tax {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="tax_no")
	private String taxNumber;
	
	@Column(name="tax_city")
	private long taxCityId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public long getTaxCityId() {
		return taxCityId;
	}

	public void setTaxCityId(long taxCityId) {
		this.taxCityId = taxCityId;
	}

	
}
