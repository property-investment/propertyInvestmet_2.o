package com.feuji.propertyinvestment.entity;

/*
 * an entity representing table property_location in DataBase
 * pojo class having getters and setters,builder,constructor using lombok
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="property_location")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyLocation {
	
	// comments to test
	@Id
	@Column(name="property_loc_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "city")
	private String city;

	@Column(name = "street")
	private String street;

	@Column(name = "pincode")
	private int pincode;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@JsonIgnore
	@OneToOne(mappedBy = "propertyLocation")
//	 @JsonBackReference
	private Property property;


}
