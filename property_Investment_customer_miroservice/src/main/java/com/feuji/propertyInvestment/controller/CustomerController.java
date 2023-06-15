package com.feuji.propertyInvestment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feuji.propertyInvestment.serviceImplementation.CustomerServiceImpl;
import com.feuji.propertyinvestment.entity.Customer;

@RestController
//added sucess fully
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@PostMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> save(@RequestBody Customer customer) {
		//System.out.println(customer);
		customerServiceImpl.save(customer);
		return ResponseEntity.ok().body(customer);
	}

	@PutMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> update(@RequestBody Customer customer) {
		customerServiceImpl.update(customer);
		return ResponseEntity.ok().body(customer);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable int id) {
		customerServiceImpl.delete(id);
	}
	
	

	@GetMapping(value = "/allcustomers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getCustomers() {
		List<Customer> customers = customerServiceImpl.getCustomer();
		return ResponseEntity.ok().body(customers);
	}
	
	@GetMapping(value = "/verify-customer/{customerMail}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String verifyCustomerLogin(@PathVariable("customerMail") String customerMail,
			@PathVariable("password") String password) {
		String result = customerServiceImpl.verifyCustomer(customerMail, password);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = null;
		try {
			json = objectMapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {

		}
		return json;
	}
	
	@GetMapping(value="/customer/{id}")
	public Customer getById(@PathVariable int id)
	{
		
		return customerServiceImpl.findById(id);
	}
	
	
	@GetMapping(value="/{customerMail}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getAdmin(@PathVariable("customerMail") String customerMail, @PathVariable("password") String password) {
		Customer customer = customerServiceImpl.getCustomer(customerMail, password);
		//System.out.println(customer+"  controller...............");
		return ResponseEntity.ok().body(customer);

	}
}
