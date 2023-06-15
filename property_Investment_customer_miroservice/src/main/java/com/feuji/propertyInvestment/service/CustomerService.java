package com.feuji.propertyInvestment.service;

import java.util.List;

import com.feuji.propertyinvestment.entity.Customer;


public interface CustomerService {

void save(Customer customer);
	
	void update(Customer customer);
	
	void delete(int id);
	
	List<Customer> getCustomer();
	
	String verifyCustomer(String customerMail ,String password);
	
	Customer getCustomer(String customerEmail, String password);
	
	public Customer findById(int cid);
	
}
