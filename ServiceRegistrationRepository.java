package com.cts.homeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.homeservice.model.CategoryRegistration;

public interface ServiceRegistrationRepository extends JpaRepository<CategoryRegistration, Integer>{
	
	List<CategoryRegistration> findAll();

}
