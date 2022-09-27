package com.cts.homeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.homeservice.model.AddService;

public interface AddServiceRepository extends JpaRepository<AddService, Integer> {

	AddService findByVendorId(String id);

	List<AddService> findByLocation(String location);
	

}
