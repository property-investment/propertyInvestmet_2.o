//package com.feuji.propertyInvestment.serviceImplementation;
//
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import com.feuji.propertyInvestment.service.PropertyOrdersServices;
//import com.feuji.propertyinvestment.entity.Customer;
//import com.feuji.propertyinvestment.entity.Property;
//import com.feuji.propertyinvestment.entity.PropertyOrder;
//import com.feuji.proppertyInvestment.repository.PropertyOrdersRepositary;
//
//@Service
//public class PropertyOrdersServiceImpl implements PropertyOrdersServices {
//	@Autowired
//	PropertyOrdersRepositary propertyOrdersRepositary;
//	@Autowired
//	private RestTemplate restTemplate;
//	@Override
//	public void save(PropertyOrder propertyOrders) {
//		propertyOrdersRepositary.save(propertyOrders);
//	}
//	@Override
//	public void update(PropertyOrder propertyOrders) {
//		propertyOrdersRepositary.save(propertyOrders);
//	}
//	@Override
//	public void delete(int id) {
//		System.out.println(propertyOrdersRepositary.findById(id).get());
//		PropertyOrder order= propertyOrdersRepositary.findById(id).get();
//		System.out.println(order);
//		Property property=order.getPropertyId();
//		System.out.println(property);
//		property.setRemainingUnits(property.getRemainingUnits()+order.getNoOfUnits());
//		//restTemplate.postForObject("http://"+EntityUtil.getUrl()+":8080/api/property/{adminId}",property,Property.class,Map.of("adminId",1));
//		propertyOrdersRepositary.deleteById(id);
//	}
//	
//	public PropertyOrder getOrder(int id)
//	{
//		return propertyOrdersRepositary.findById(id).get();
//	}
//	
//	@Override
//	public PropertyOrder sell(PropertyOrder orders)
//	{
//		PropertyOrder order= propertyOrdersRepositary.findById(orders.getOrderId()).get();
//		System.out.println(order);
//		int sellingUnits =order.getNoOfUnits()-orders.getNoOfUnits();
//		System.out.println(sellingUnits);
//		
//
//		Property property=order.getPropertyId();
//		System.out.println(property+"property");
//		property.setRemainingUnits(property.getRemainingUnits()+sellingUnits);
//		System.out.println(property);
//		order.setNoOfUnits(orders.getNoOfUnits());
//		order.setPropertyId(property);
//		
////		property.setRemainingUnits(property.getRemainingUnits()+order.getNoOfUnits());
////		System.out.println(property.getRemainingUnits());
////      restTemplate.postForObject("http://"+EntityUtil.getUrl()+":8080/api/property/{adminId}",property,Property.class,Map.of("adminId",1));
//		propertyOrdersRepositary.save(order);
//		return order;
//		
//	}
//	@Override
//	public List<PropertyOrder> getPropertyOrders() {
//		return propertyOrdersRepositary.findAll();
//	}
//	public PropertyOrder save(PropertyOrder orders, int cid, int pid) {	
//		System.out.println(cid+" "+pid);
//		//restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//		Customer customer = restTemplate.getForObject("http://34.122.139.85:8081/api/customer/{cid}",Customer.class,cid);		   
//		//setted customer
//		orders.setCustomerId(customer);	
//		Property property = restTemplate.getForObject("http://34.122.139.85:8080/api/property/{pid}",
//				Property.class,pid);
//		
//		System.out.println(property);
//		System.out.println(property.getRemainingUnits());
//		property.setBlockedUnits(property.getBlockedUnits()+orders.getNoOfUnits());
//		System.out.println(property);
//		
//		int adminId=1;
//		orders.setPropertyId(property);
//		restTemplate.postForObject("http://34.122.139.85:8080/api/property/{adminId}",property,Property.class,Map.of("adminId",adminId));
//		propertyOrdersRepositary.saveAndFlush(orders);
//		return orders;
//
//	}
//	@Override
//	public void update(PropertyOrder orders, int cid, int pid)
//	{
//		//restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//		Customer customer = restTemplate.getForObject("http://34.122.139.85:8081/api/customer/{cid}",Customer.class,cid);		   
//		orders.setCustomerId(customer);	
//		Property property = restTemplate.getForObject("http://34.122.139.85:8080/api/property/{pid}",
//				Property.class,pid);
//		System.out.println("before"+property.getRemainingUnits() );
//		orders.setCustomerId(customer);	
//		property.setRemainingUnits(property.getRemainingUnits()-orders.getNoOfUnits());
//		property.setBlockedUnits(property.getBlockedUnits()-orders.getNoOfUnits());
//		orders.setPropertyId(property);
//		System.out.println(property.getRemainingUnits());
//		//restTemplate.postForObject("http://"+EntityUtil.getUrl()+":8080/api/property/{adminId}",property,Property.class,Map.of("adminId",adminId));
//		propertyOrdersRepositary.saveAndFlush(orders);
//		
//	}
//	@Override
//	public List<PropertyOrder> getPropertyOrdersByQuerry(int id) {
//		System.out.println(id+"  query id");
//		return propertyOrdersRepositary.getOrder(id).get();
//	}
//	@Override
//	public void sell(int id) {
//		// TODO Auto-generated method stub
//		
//	}
//	public void delete(int id, String status) {
//		
//		PropertyOrder ord=propertyOrdersRepositary.findById(id).get();
//		Property property=ord.getPropertyId();
//		property.setBlockedUnits(property.getBlockedUnits()-ord.getNoOfUnits());
//		ord.setPropertyId(property);
//		propertyOrdersRepositary.save(ord);
//		propertyOrdersRepositary.deleteById(id);
//		
//		
//		
//	}
//
//}


package com.feuji.propertyInvestment.serviceImplementation;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.feuji.propertyInvestment.service.PropertyOrdersServices;
import com.feuji.propertyinvestment.entity.Customer;
import com.feuji.propertyinvestment.entity.Property;
import com.feuji.propertyinvestment.entity.PropertyOrder;
import com.feuji.proppertyInvestment.repository.PropertyOrdersRepositary;
import com.feuji.util.EntityUtil;
 
@Service
public class PropertyOrdersServiceImpl implements PropertyOrdersServices {
	@Autowired
	PropertyOrdersRepositary propertyOrdersRepositary;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EntityUtil EntityUtil;
	
	@Override
	public void save(PropertyOrder propertyOrders) {
		propertyOrdersRepositary.save(propertyOrders);
	}
	@Override
	public void update(PropertyOrder propertyOrders) {
		propertyOrdersRepositary.save(propertyOrders);
	}
	@Override
	public void delete(int id) {
//		System.out.println(propertyOrdersRepositary.findById(id).get());

		Optional<PropertyOrder> optionalOrder= propertyOrdersRepositary.findById(id);
		if(optionalOrder.isPresent()) {
			PropertyOrder order=optionalOrder.get();
			System.out.println(order);
			Property property = order.getPropertyId();
		    System.out.println(property);
			property.setRemainingUnits(property.getRemainingUnits()+order.getNoOfUnits());
			propertyOrdersRepositary.deleteById(id);
			System.out.println(optionalOrder.get());
		}else {
			throw new NoSuchElementException("No order with given Id exits");
		}
		//restTemplate.postForObject("http://"+EntityUtil.getUrl()+":8080/api/property/{adminId}",property,Property.class,Map.of("adminId",1));
	}
	
	@Override
	public PropertyOrder sell(PropertyOrder orders)
	{
		Optional<PropertyOrder> optionalOrder= propertyOrdersRepositary.findById(orders.getOrderId());
		if(optionalOrder.isPresent()) {
			PropertyOrder order = optionalOrder.get();
			System.out.println(order);
			int sellingUnits =order.getNoOfUnits()-orders.getNoOfUnits();
			System.out.println(sellingUnits);
			

			Property property=order.getPropertyId();
			System.out.println(property+"property");
			property.setRemainingUnits(property.getRemainingUnits()+sellingUnits);
			System.out.println(property);
			order.setNoOfUnits(orders.getNoOfUnits());
			order.setPropertyId(property);
			
//			property.setRemainingUnits(property.getRemainingUnits()+order.getNoOfUnits());
//			System.out.println(property.getRemainingUnits());
			//restTemplate.postForObject("http://"+EntityUtil.getUrl()+":8080/api/property/{adminId}",property,Property.class,Map.of("adminId",1));
			propertyOrdersRepositary.save(order);
		}else {
			throw new NoSuchElementException("No order with given id exists");
		}
		return orders;

		
	}
	@Override
	public List<PropertyOrder> getPropertyOrders() {
		return propertyOrdersRepositary.findAll();
	}
	public PropertyOrder save(PropertyOrder orders, int cid, int pid) {	
		System.out.println(cid+" "+pid);
		//restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		System.out.println(EntityUtil.getUrl()+"in class");
		Customer customer = restTemplate.getForObject("http://customer-service/api/customer/customer/{cid}",Customer.class,cid);		   
		//setted customer
		orders.setCustomerId(customer);	
		Property property = restTemplate.getForObject("http://property-service/api/property/{pid}",
				Property.class,pid);
		//System.out.println("123456789098765");
		if(property != null) {
			System.out.println(property);
			System.out.println(property.getRemainingUnits());
			property.setBlockedUnits(property.getBlockedUnits()+orders.getNoOfUnits());
			System.out.println(property);
		}else {
			throw new NoSuchElementException("No property with given id exists");
		}
		//property.setRemainingUnits(property.getRemainingUnits()-property.getBlockedunits());
		//System.out.println(property.getRemainingUnits());
		
		//int adminId=property.getAdmins().get(property.getAdmins().size()-1).getAdminId();
		//setting property
		int adminId=1;
		orders.setPropertyId(property);
		restTemplate.put("http://property-service/api/property/update-property/1",property,Property.class,Map.of("adminId",adminId));
		propertyOrdersRepositary.saveAndFlush(orders);
		return orders;
		
	

	}
	@Override
	public void update(PropertyOrder orders, int cid, int pid)
	{
		//restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		Customer customer = restTemplate.getForObject("http://customer-service/api/customer/customer/{cid}",Customer.class,cid);		   
		orders.setCustomerId(customer);	
		Property property = restTemplate.getForObject("http://property-service/api/property/{pid}",
				Property.class,pid);
		if(property != null) {
			System.out.println("before"+property.getRemainingUnits() );
			orders.setCustomerId(customer);	
			property.setRemainingUnits(property.getRemainingUnits()-orders.getNoOfUnits());
			property.setBlockedUnits(property.getBlockedUnits()-orders.getNoOfUnits());
			orders.setPropertyId(property);
			System.out.println(property.getRemainingUnits());
		}else {
			throw new NoSuchElementException("No property with given id exists");
		}
		
		propertyOrdersRepositary.saveAndFlush(orders);
		
	}
	@Override
	public List<PropertyOrder> getPropertyOrdersByQuerry(int id) {
		Optional<List<PropertyOrder>> optionalOrders = propertyOrdersRepositary.getOrder(id);
		if(optionalOrders.isPresent()) {
			List<PropertyOrder> orders = optionalOrders.get();
			System.out.println(id+"  query id");
			return orders;
		}else {
			return Collections.emptyList();
		}
		//return propertyOrdersRepositary.getOrder(id).get();
	}
	@Override
	public void sell(int id) {
		// TODO Auto-generated method stub
		
	}
	public void delete(int id, String status) {
		
		PropertyOrder ord=propertyOrdersRepositary.findById(id).get();
		Property property=ord.getPropertyId();
		property.setBlockedUnits(property.getBlockedUnits()-ord.getNoOfUnits());
		ord.setPropertyId(property);
		propertyOrdersRepositary.save(ord);
		propertyOrdersRepositary.deleteById(id);
		
		
		
	}
	public PropertyOrder getOrder(int orderId) {
		
		PropertyOrder optionalOrders = propertyOrdersRepositary.getById(orderId);
			
			return optionalOrders;
		
	}
}