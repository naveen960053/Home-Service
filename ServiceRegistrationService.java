package com.cts.homeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cts.homeservice.model.CategoryRegistration;
import com.cts.homeservice.repository.ServiceRegistrationRepository;

@Service
public class ServiceRegistrationService {
	
	@Autowired
	ServiceRegistrationRepository serviceRepository;
	
	public void addService(CategoryRegistration service)
	{
		
		serviceRepository.save(service);
	}

	public List<CategoryRegistration> getService()
	{
		return serviceRepository.findAll();
	}

}
