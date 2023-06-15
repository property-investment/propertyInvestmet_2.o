package com.feuji.propertyInvestment.service;

import java.util.List;

import com.feuji.propertyinvestment.entity.Admin;

public interface AdminService {

	void save(Admin admin);

	void update(Admin admin);

	void delete(int id);

	List<Admin> getAdmins();

	Admin getAdmin(String adminName, String password);

	Admin getAdmin(int id);
}
