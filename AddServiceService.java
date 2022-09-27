package com.cts.homeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.homeservice.model.AddService;
import com.cts.homeservice.model.VendorRegistration;
import com.cts.homeservice.repository.AddServiceRepository;
import com.cts.homeservice.repository.VendorRegistrationRepository;

@Service
public class AddServiceService {
	
	
	AddServiceRepository addServiceRepository;
	VendorRegistrationRepository vendorRegistrationRepository;
	
	@Autowired
	public AddServiceService(AddServiceRepository addServiceRepository,
			VendorRegistrationRepository vendorRegistrationRepository) {
		super();
		this.addServiceRepository = addServiceRepository;
		this.vendorRegistrationRepository = vendorRegistrationRepository;
	}


	public void createService(AddService addService,String userName)
	{
		int id = Integer.parseInt(userName);
		addService.setVendorId(userName);
		VendorRegistration vendor = vendorRegistrationRepository.findById(id);
		addService.setName(vendor.getFirstName()+" "+vendor.getLastName());
		addServiceRepository.save(addService);
	}
	
	public AddService getProfile(String id)
	{
		return addServiceRepository.findByVendorId(id);
	}

}
