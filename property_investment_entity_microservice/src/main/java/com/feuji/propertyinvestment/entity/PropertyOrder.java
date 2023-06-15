 package com.feuji.propertyinvestment.entity;
/*
 * an entity representing table propertyOrders in DataBase
 * pojo class having getters and setters,builder,constructor using lombok
 */

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PropertyOrder")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class PropertyOrder {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id") 	
	private int orderId;
	@ManyToOne( cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
	@JsonIgnore
	@JsonManagedReference
//	@JsonBackReference
	private Customer customerId;
	
	@ManyToOne( cascade = CascadeType.MERGE,fetch = FetchType.LAZY)  
	@JoinColumn(name = "property_id",referencedColumnName = "property_id")
	@JsonIgnore
	@JsonManagedReference
//	@JsonBackReference
	private Property propertyId;
	
	@Column(name="order_price")
	private double orderPrice;
	
	@Column(name="no_units")
	private int noOfUnits;
	
	@Column(name="orderStatus")
	private String orderStatus;
	
	@Column(name="order_date")
	private Date orderDate;
	
	{
		this.orderDate=new Date();
		//this.orderPrice=this.propertyId.getShareVal()*this.noOfUnits;
	}

	@Override
	public String toString() {
		return "Your Order Conformation details \n Order Id=" + orderId + "\n Order Price=" + orderPrice + "\n Number Of Units=" + noOfUnits
				+ "\n Order Status has changed to=" + orderStatus + "\n Order Date=" + orderDate + "\n Customer Name= "+customerId.getCustomerName()+"\n Property Name="+propertyId.getName();
	}

	

}
