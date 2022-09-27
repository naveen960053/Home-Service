package com.cts.homeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.homeservice.model.AdminRegistration;
import com.cts.homeservice.model.Users;
import com.cts.homeservice.repository.AdminRegistrationRepository;
import com.cts.homeservice.repository.UserRepository;

@Service
public class AdminRegistrationService {

	AdminRegistrationRepository adminRepository;
	UserRepository userRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public AdminRegistrationService(AdminRegistrationRepository adminRepository, UserRepository userRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.adminRepository = adminRepository;
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public void createAdmin(AdminRegistration admin) {
		admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
		Users user = new Users();
		user.setUserName(admin.getEmail());
		user.setPassword(admin.getPassword());
		user.setRoles("ADMIN");
		user.setActive(true);
		userRepository.save(user);
		adminRepository.save(admin);
	}

}
