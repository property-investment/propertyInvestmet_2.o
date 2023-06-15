package com.feuji.proppertyInvestment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.feuji.propertyinvestment.entity.PropertyOrder;


public interface PropertyOrdersRepositary extends JpaRepository<PropertyOrder, Integer> {

	@Query(value="select ord.* from propertyinvestment12.customer cust,propertyinvestment12.property_order ord where cust.customer_id=ord.customer_id and  cust.customer_id=:id",nativeQuery=true)
	Optional<List<PropertyOrder>> getOrder(@Param("id") int id);
}
