package com.feuji.propertyinvestment.entity;

/*
 * an entity representing table admin in DataBase
 * pojo class having getters and setters,builder,constructor using lombok
 */
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="admin")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @Column(name="admin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    @Column(name="admin_name")
    private String adminName;

    @Column(name="admin_password")
    private String password;

    @Column(name="status")
    private String status;

	//@ManyToMany(mappedBy = "admins", cascade = CascadeType.ALL)''''''
    @ManyToMany( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "property_admin", joinColumns = {
            @JoinColumn(name = "property_id") }, inverseJoinColumns = {
                    @JoinColumn(name = "admin_id") })
    
   //@Column(nullable = true)
    //@JsonIgnore
    @JsonBackReference
    private List<Property> properties;
	
	
}
