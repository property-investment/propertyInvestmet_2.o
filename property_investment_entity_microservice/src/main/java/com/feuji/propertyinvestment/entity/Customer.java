 package com.feuji.propertyinvestment.entity;

 /*
  * an entity representing table customer in DataBase
  * pojo class having getters and setters,builder,constructor using lombok
  */
 
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customer")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int id;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="e_Mail")
    private String customerMail;

    @Column(name="phone_no")
    private long customerPhno;
    
    @Column(name="password")
    private String password;

    
    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_location_id",referencedColumnName = "customer_location_id")
    @JsonManagedReference
    private CustomerLocation customerlocation;
    
    @OneToMany(mappedBy = "customerId")
    @JsonBackReference
  // @JsonManagedReference
    private List<PropertyOrder> orderIds; 
}
