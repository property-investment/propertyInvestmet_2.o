package com.feuji.propertyInvestment.controller;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.feuji.PropertyinvestmentAdminMicroserviceApplication;
import com.feuji.propertyInvestment.service.AdminService;
import com.feuji.propertyInvestment.serviceImplementation.AdminServiceImpl;
import com.feuji.propertyinvestment.entity.Admin;
import org.junit.jupiter.api.Test;



@SpringBootTest(classes = PropertyinvestmentAdminMicroserviceApplication.class)

public class TestAdmin {
	
	@Mock
	AdminServiceImpl adminService;
	@InjectMocks
	AdminController adminController;
	
	private Admin admin;
	@BeforeEach
	public void setup() {
		admin=new Admin();
	}	
	@Test
	public void testAdminDetails() {

		admin.setAdminName("siri");
		admin.setPassword("null");
		admin.setStatus("active");

		when(adminService.getAdmin("siri","null")).thenReturn(admin);

		ResponseEntity<Admin> getadmin = adminController.getAdmin("siri","null");

		System.out.println(getadmin);
		
		assertEquals("siri", getadmin.getBody().getAdminName());
		assertEquals("null", getadmin.getBody().getPassword());
		assertEquals("active", getadmin.getBody().getStatus());
		
	}
	
	@Test
	public void testAdminVerify() {
		admin.setAdminName("siri");
		admin.setPassword("null");
		admin.setStatus("active");
		when(adminService.verifyAdmin("siri","null")).thenReturn("Data Matched");
		String data=adminController.verifyAdminLogin("siri","null");
		assertEquals("\"Data Matched\"", data);		
	}



}
