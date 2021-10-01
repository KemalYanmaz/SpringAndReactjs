package com.kemalyanmaz.portfoliowork.dataAccess.concretes;

import java.sql.Date;

public class OfferDto {

	private long id;
	private EmployeeDto employee;
	private CustomerDto customer;
	private ProductDto product;
	private double totalPrice;
	private CurrencyDto currency;
	private Date offerDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public EmployeeDto getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}
	public CustomerDto getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
	public ProductDto getProduct() {
		return product;
	}
	public void setProduct(ProductDto product) {
		this.product = product;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public CurrencyDto getCurrency() {
		return currency;
	}
	public void setCurrency(CurrencyDto currency) {
		this.currency = currency;
	}
	public Date getOfferDate() {
		return offerDate;
	}
	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}
	
	
	
}
