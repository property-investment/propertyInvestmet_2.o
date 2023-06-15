package com.feuji.propertyInvestment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feuji.propertyInvestment.serviceImplementation.AdminServiceImpl;
import com.feuji.propertyinvestment.entity.Admin;

@RestController
public class AdminController 
{
	@Autowired(required = true)
	AdminServiceImpl adminServiceImpl;
	

	@PostMapping(value = "/admin")
	public  ResponseEntity<Admin> save(@RequestBody Admin admin) {
		adminServiceImpl.save(admin);
		return ResponseEntity.ok().body(admin);
	}
	
	@PutMapping(value = "/admin")
	public  ResponseEntity<Admin> update(@RequestBody Admin admin) {
		adminServiceImpl.update(admin);
		return ResponseEntity.ok().body(admin);
	}
	
	@DeleteMapping(value = "/admin/{id}")
	public void delete(@PathVariable int id ) {
		adminServiceImpl.delete(id);
	}
	

	@GetMapping(value = "/admin")
	public ResponseEntity<List<Admin>> getAdmins() {
		List<Admin> admins= adminServiceImpl.getAdmins();
		return ResponseEntity.ok().body(admins);
	}
	
	
	@GetMapping(value = "/admin/{id}")
	public Admin getAdmin(@PathVariable int id) {
		Admin admins= adminServiceImpl.getAdmin(id);
		return admins;
	}
	
	

	@GetMapping(value="/admin/verify-admin/{adminName}/{password}")
	public String verifyAdminLogin(@PathVariable("adminName") String adminName, @PathVariable("password") String password) {
		String result = adminServiceImpl.verifyAdmin(adminName, password);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = null;
		try {
			json = objectMapper.writeValueAsString(result);
		}catch(JsonProcessingException e){
			e.printStackTrace();
		}
		System.out.println(json);
		return json;
	}
	
	@GetMapping(value="/admin/{adminName}/{password}")
	public ResponseEntity<Admin> getAdmin(@PathVariable("adminName") String adminName, @PathVariable("password") String password) {
		Admin admin = adminServiceImpl.getAdmin(adminName, password);
		System.out.println(admin+" "+"controller");
		return ResponseEntity.ok().body(admin);
	}
	
	
}
