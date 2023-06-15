package com.feuji.propertyInvestment.service;


import java.util.List;

import com.feuji.propertyinvestment.entity.PropertyOrder;




public interface PropertyOrdersServices {
	
	void save(PropertyOrder propertyOrders);
	
    void update(PropertyOrder propertyOrders);
	
	void delete(int id);
	
	List<PropertyOrder> getPropertyOrders();
	

	PropertyOrder save(PropertyOrder orders, int cid, int pid);

	void sell(int id);

	void update(PropertyOrder orders, int cid, int pid);

	List<PropertyOrder> getPropertyOrdersByQuerry(int id);

	PropertyOrder sell(PropertyOrder orders);
	

}