package com.feuji.propertyinvestment.entity;

/*
 * an entity representing table properties in DataBase
 * pojo class having getters and setters,builder,constructor using lombok
 */

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "properties")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class Property {
	@Id
	@Column(name = "property_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "property_name")
	private String name;

	@Column(name = "area")
	private double area;

	@Column(name = "totalCost")
	private double totalCost;

	@Column(name = "shareCost_per_unit")
	private double shareVal;

	@Column(name = "total_no_units")
	private int totalUnits;

	@Column(name = "remaining_units")
	private int remainingUnits;

	@Column(name = "starting_date")
	private Date startDate;

	@Column(name = "status")
	private String status;

	@ManyToMany( cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(name = "property_admin", joinColumns = {
            @JoinColumn(name = "property_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "admin_id") })
	@JsonIgnore
	//@JsonManagedReference
	//@JsonBackReference
	private List<Admin> admins;

	@Column(name = "last_modeifedon")
	private Date modifiedOn;

	@Column(name="image_url")
	private String imageUrl;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="propertyLocation_id",referencedColumnName = "property_loc_id")
	private PropertyLocation propertyLocation;
	
	
	@OneToMany(mappedBy = "propertyId")
//	@JsonManagedReference
	@JsonIgnoreProperties
	@JsonBackReference
	private List<PropertyOrder> orderIds;
	
	
	@Column(name="blocked_units")
	private int blockedUnits;
	
	
	
	//added attribute
	@Column(name="yield_value")
	private double yield_value;
	
	{
		this.modifiedOn=new Date();
//		this.startDate=new Date();
	}
}
