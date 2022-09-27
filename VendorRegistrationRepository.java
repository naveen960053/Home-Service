package com.cts.homeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.homeservice.model.VendorRegistration;

public interface VendorRegistrationRepository extends JpaRepository<VendorRegistration, Integer> {
	
	VendorRegistration findByEmail(String email);

	VendorRegistration findById(int userName);

}
