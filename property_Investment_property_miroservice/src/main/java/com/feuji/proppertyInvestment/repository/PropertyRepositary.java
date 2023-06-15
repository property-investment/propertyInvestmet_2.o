package com.feuji.proppertyInvestment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feuji.propertyinvestment.entity.Property;



public interface PropertyRepositary extends JpaRepository<Property, Integer> {
	
}
