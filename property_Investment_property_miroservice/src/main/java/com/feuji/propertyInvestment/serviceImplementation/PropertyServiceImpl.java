package com.feuji.propertyInvestment.serviceImplementation;

import java.util.Date;
import java.util.List;
import java.util.stream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feuji.propertyInvestment.service.PropertyService;
import com.feuji.propertyinvestment.entity.Admin;
import com.feuji.propertyinvestment.entity.Property;
import com.feuji.proppertyInvestment.repository.PropertyRepositary;
import com.feuji.util.EntityUtil;

@Service
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	PropertyRepositary propertyRepositary;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private EntityUtil EntityUtil;

	@Override
	public void save(Property property, int id) {
		Admin admin=restTemplate.getForObject("http://admin-service/api/admin/{id}", Admin.class,id);
		System.out.println(admin);
		property.setAdmins(List.of(admin));
		propertyRepositary.save(property);

	}

	@Override
	public void update(Property property, int id) {
		System.out.println("enterd into update of save");

		Admin admin=restTemplate.getForObject("http://admin-service/api/admin/{id}", Admin.class,id);
		System.out.println(admin);
		property.setAdmins(List.of(admin));
		propertyRepositary.save(property);
	}

	@Override
	public void delete(int id) {
		propertyRepositary.deleteById(id);		
	}

	@Override
	public List<Property> getProperties() {
		  return propertyRepositary.findAll().stream().filter(property->property.getStartDate().before(new Date())).collect(Collectors.toList());
	}
	

	@Override
	public Property findById(int id) {
		
		return propertyRepositary.findById(id).get();
	}

	@Override
	public void save(Property property) {

		propertyRepositary.save(property);
	}
	
	
	
}
