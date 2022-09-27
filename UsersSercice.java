package com.cts.homeservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.homeservice.model.Users;
import com.cts.homeservice.repository.UserRepository;

@Service
public class UsersSercice {
	
	UserRepository userRepository;

	@Autowired
	public UsersSercice(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public String getAuthority(String userName)
	{
		String authority;
		Optional<Users> user = userRepository.findByUserName(userName);
		authority=user.get().getRoles();
		return authority;
	}
	
	
	

}
