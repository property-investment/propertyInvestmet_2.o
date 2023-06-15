package com.feuji.propertyInvestment.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.feuji.propertyInvestment.controller.PropertyOrderController;
import com.feuji.propertyinvestment.entity.PropertyOrder;
import com.feuji.proppertyInvestment.repository.PropertyOrdersRepositary;

@Service
public class CacheClass {
	
	@Autowired
	PropertyOrdersRepositary propertyOrdersRepositary;
	List<PropertyOrder>   orders=null;
	@Autowired
	PropertyOrderController controller=new PropertyOrderController();

	public List<PropertyOrder> getPropertyOrders() {
		
		
		if(controller.updated)
		{
			orders=null;
		}
		
		if(orders==null)
		{
			
			orders=propertyOrdersRepositary.findAll();
			
			return orders;

		}
		else
		{
			System.out.println("not a null");
//			try {
//				Thread.sleep(2);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			return orders;
		}
	}
	

}
