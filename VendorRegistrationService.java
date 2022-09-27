package com.cts.homeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.homeservice.model.Users;
import com.cts.homeservice.model.VendorRegistration;
import com.cts.homeservice.repository.UserRepository;
import com.cts.homeservice.repository.VendorRegistrationRepository;

@Service
public class VendorRegistrationService {

	VendorRegistrationRepository vendorRegistrationRepository;
	UserRepository userRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired	
	public VendorRegistrationService(VendorRegistrationRepository vendorRegistrationRepository,
			UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.vendorRegistrationRepository = vendorRegistrationRepository;
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	
	public String createUser(VendorRegistration vendorDetails)
	{
		vendorDetails.setPassword(bCryptPasswordEncoder.encode(vendorDetails.getPassword()));
		vendorRegistrationRepository.save(vendorDetails);
		VendorRegistration vendor = vendorRegistrationRepository.findByEmail(vendorDetails.getEmail());
		Users user = new Users();
		String name = Integer.toString(vendor.getId());
		user.setUserName(name);
		user.setPassword(vendorDetails.getPassword());
		user.setRoles("VENDOR");
		user.setActive(true);
		userRepository.save(user);
		return name;
		
	}

}
