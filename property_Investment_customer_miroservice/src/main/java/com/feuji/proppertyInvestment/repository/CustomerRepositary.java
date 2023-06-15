package com.feuji.proppertyInvestment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.feuji.propertyinvestment.entity.Customer;
import com.feuji.propertyinvestment.entity.PropertyOrder;

public interface CustomerRepositary extends JpaRepository<Customer, Integer>{
	 Optional<Customer> findByCustomerMailAndPassword(String customerMail, String password);
	 
	 Optional<Customer> findById(int id);
}
