package com.cts.homeservice.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.homeservice.model.UserRegistration;
import com.cts.homeservice.model.Users;
import com.cts.homeservice.repository.UserRegistrationRepository;
import com.cts.homeservice.repository.UserRepository;

@Service
public class UserRegistrationService {
	
	UserRepository uRepository;
	UserRegistrationRepository rRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserRegistrationService(UserRepository uRepository,UserRegistrationRepository rRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.uRepository = uRepository;
		this.rRepository=rRepository;
		this.bCryptPasswordEncoder=bCryptPasswordEncoder;
	}
	
	public void createUser(UserRegistration userDetails)
	{
		String password = bCryptPasswordEncoder.encode(userDetails.getPassword());
		userDetails.setPassword(password);
		Users user = new Users();
		user.setActive(true);
		user.setUserName(userDetails.getEmail());
		user.setPassword(password);
		user.setRoles("USER");
		rRepository.save(userDetails);
		uRepository.save(user);
		
	}

}
