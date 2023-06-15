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
import org.springframework.web.bind.annotation.RestController;

import com.feuji.propertyInvestment.serviceImplementation.PropertyServiceImpl;
import com.feuji.propertyinvestment.entity.Property;

@RestController
public class PropertyController {
	@Autowired
	PropertyServiceImpl propertyServiceImpl;
	
	@PostMapping(value = "/property/{adiminid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Property> save(@RequestBody Property property,@PathVariable int adiminid) {
		propertyServiceImpl.save(property,adiminid);
		return ResponseEntity.ok().body(property);
	}
	
	@PutMapping(value = "property/update-property/{adminId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Property update(@RequestBody Property property,@PathVariable int adminId ) {
		propertyServiceImpl.update(property,adminId);
		return property;
	}
	
	@DeleteMapping(value = "/deleteproperty/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable int id ) {
		propertyServiceImpl.delete(id);
	}
	
	@GetMapping(value = "/property",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Property>> getProperties() {
		List<Property> properties= propertyServiceImpl.getProperties();
		return ResponseEntity.ok().body(properties);
	}
	@GetMapping(value = "/property/{pid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Property getProperty(@PathVariable  int pid) {
		
		Property property= propertyServiceImpl.findById(pid);
		return property;
	}
}
