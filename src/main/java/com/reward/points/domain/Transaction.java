package com.reward.points.domain;
import java.time.LocalDate;


//We could use this POJO as Entity class and associate with table and use in JPA to pull data

public class Transaction {	
	
    private Long id;	
	
	private Long customer;	
	
	private double amount;	
	
	private LocalDate  date;		

	public Transaction(Long id, Long customer, double amount, LocalDate date) {
		super();
		this.id = id;
		this.customer = customer;
		this.amount = amount;
		this.date = date;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomer() {
		return customer;
	}

	public void setCustomer(Long customer) {
		this.customer = customer;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
