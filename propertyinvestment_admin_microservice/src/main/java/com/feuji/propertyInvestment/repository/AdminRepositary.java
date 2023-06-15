package com.feuji.propertyInvestment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.feuji.propertyinvestment.entity.Admin;

public interface AdminRepositary extends JpaRepository<Admin, Integer> {
	Optional<Admin> findByAdminNameAndPassword(String adminName, String password);

}
