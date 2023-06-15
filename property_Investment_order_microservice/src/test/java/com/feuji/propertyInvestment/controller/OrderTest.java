package com.feuji.propertyInvestment.controller;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.feuji.PropertyInvestmentOrdersMicroservice1Application;
import com.feuji.propertyInvestment.serviceImplementation.PropertyOrdersServiceImpl;
import com.feuji.propertyinvestment.entity.Customer;
import com.feuji.propertyinvestment.entity.Property;
import com.feuji.propertyinvestment.entity.PropertyOrder;

@SpringBootTest(classes =PropertyInvestmentOrdersMicroservice1Application.class )
public class OrderTest {
	
	@Mock
	PropertyOrdersServiceImpl impl;
	@InjectMocks
	PropertyOrderController  controller;
	private PropertyOrder order;
	private Property property;
	private Customer customer;
	@BeforeEach
	public void setup() {

		order=new PropertyOrder();	
		property=new  Property();
		customer=new Customer();
	}	
	@Test
	public void testOrder()
	{
		
		
//		order.setNoOfUnits(19);
//		order.setOrderPrice(5676.876);
//		order.setOrderStatus("pending");
//		order.setCustomerId(customer);
//		order.setPropertyId(property);
//		
//		when(impl.save(order,property.getId(),customer.getId())).thenReturn(order);
//		
//		PropertyOrder order1=controller.save( order.getPropertyId().getId(),order.getCustomerId().getId(),order).getBody();
//		
//		assertEquals(order1.getOrderStatus(),order.getOrderStatus());
//		assertEquals(order1.getOrderDate(),order.getOrderDate());
//		assertEquals(order1.getOrderPrice(),order.getOrderPrice());	
	}
	@Test
	public void sell() {
		
//		order.setNoOfUnits(19);
//		order.setOrderPrice(5676.876);
//		order.setOrderStatus("pending");
//		order.setCustomerId(customer);
//		order.setPropertyId(property);
//		
//		when(impl.sell(order)).thenReturn(order);
//		
//		System.out.println(order.getOrderDate()+"orderid");
//		
//		PropertyOrder order1=controller.sell(order).getBody();
//		
//		assertEquals(order1.getOrderStatus(),order.getOrderStatus());
//		assertEquals(order1.getPropertyId(),order.getPropertyId());
//		assertEquals(order1.getOrderId(),order.getOrderId());
//			
	}
}
