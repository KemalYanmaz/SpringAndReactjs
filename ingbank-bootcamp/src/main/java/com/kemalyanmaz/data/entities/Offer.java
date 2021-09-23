package com.kemalyanmaz.data.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="offers")
public class Offer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@OneToOne(targetEntity=Employee.class,cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id",referencedColumnName="ID")
	private Employee employee;
	
	@OneToOne(targetEntity=Customer.class,cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id",referencedColumnName="ID")
	private Customer customer;
	
	@OneToOne(targetEntity=Product.class,cascade=CascadeType.ALL)
	@JoinColumn(name="product_id",referencedColumnName="ID")
	private Product product;
	
	@Column(name="total_price")
	private double totalPrice;
	
	@OneToOne(targetEntity=Currency.class,cascade=CascadeType.ALL)
	@JoinColumn(name="currency_id",referencedColumnName="ID")
	private Currency currency;
	
	@Column(name="offer_date")
	private Date offerDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Date getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}
	
	
}
