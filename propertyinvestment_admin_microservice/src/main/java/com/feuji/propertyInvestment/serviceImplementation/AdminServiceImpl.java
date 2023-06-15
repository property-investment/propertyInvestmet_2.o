package com.feuji.propertyInvestment.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.propertyInvestment.repository.AdminRepositary;
import com.feuji.propertyInvestment.service.AdminService;
import com.feuji.propertyinvestment.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepositary adminRepositary;

	@Override
	public void save(Admin admin) {
		adminRepositary.save(admin);
	}

	@Override
	public void update(Admin admin) {
		adminRepositary.saveAndFlush(admin);

	}

	@Override
	public void delete(int id) {
		adminRepositary.deleteById(id);

	}

	@Override
	public List<Admin> getAdmins() {
		return adminRepositary.findAll();
	}
	
	@Override
	public Admin getAdmin(int id) {
		return adminRepositary.findById(id).get();
	}

	@Override
	public Admin getAdmin(String adminName, String password) {
		Admin admin = adminRepositary.findByAdminNameAndPassword(adminName, password).get();
		return admin;
	}

	public String verifyAdmin(String adminName, String password) {
		Admin admin = adminRepositary.findByAdminNameAndPassword(adminName, password).get();
		System.out.println(admin);
		if (admin != null) {
			System.out.println(admin);
			return "Data Matched";
		} else {
			return "Not Matched";
		}
	}

}
