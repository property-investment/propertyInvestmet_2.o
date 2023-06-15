package com.feuji.propertyInvestment.service;

import java.util.List;

import com.feuji.propertyinvestment.entity.Property;


public interface PropertyService {
	void save(Property property);

	//void update(Property property);

	void delete(int id);

	List<Property> getProperties();
	Property findById(int id);

	void update(Property property, int id);

	void save(Property property, int id);
}