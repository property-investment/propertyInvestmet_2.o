package com.feuji.propertyInvestment.serviceImplementation;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.propertyInvestment.service.CustomerService;
import com.feuji.propertyinvestment.entity.Customer;
import com.feuji.proppertyInvestment.repository.CustomerRepositary;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepositary customerRepositary;


	@Override
	public void save(Customer customer) {
		

	customerRepositary.save(customer);
	}

	@Override
	public void update(Customer customer) {
		customerRepositary.save(customer);

	}

	@Override
	public void delete(int id) {
		customerRepositary.deleteById(id);

	}

	@Override
	public List<Customer> getCustomer() {
		List<Customer> cust=customerRepositary.findAll();
		Collections.sort( cust,new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {
				return o1.getId()-o2.getId();
			}
	 
		
		});
		return cust;
	}
	@Override
	public Customer findById(int cid) {
		
		return customerRepositary.findById(cid).get();
	}

	

	@Override
	public String verifyCustomer(String customerMail, String password) {

		Optional<Customer> login = customerRepositary.findByCustomerMailAndPassword(customerMail, password);
		if (login.isPresent()) {
			return "Data Matched";
		} else {
			return "Not Matched";
		}
	}

	@Override
	public Customer getCustomer(String customerEmail, String password) {
		Optional<Customer> customerOptional = customerRepositary.findByCustomerMailAndPassword(customerEmail, password);
		if(customerOptional.isPresent()) {
			return customerOptional.get();
		}else {
		    throw new NoSuchElementException("Customer Not Found");
		}
	}

}
