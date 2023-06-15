package com.feuji.propertyinvestment.entity;

/*
 * an entity representing table customer_Location in DataBase
 * pojo class having getters and setters,builder,constructor using lombok
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="customer_location")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerLocation {
	
	@Id
	@Column(name="customer_location_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
	
	@Column(name="pincode")
	private String pinCode;
	
	@OneToOne(mappedBy = "customerlocation")
	 @JsonBackReference
	private Customer customer;
	
}
