package com.cts.homeservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.homeservice.model.Users;
import com.cts.homeservice.repository.UserRepository;

@Service
public class UsersDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	UserRepository uRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Load user by name");
		Optional<Users> user = uRepository.findByUserName(username);
		user.orElseThrow(()->new UsernameNotFoundException(username+"Not found"));
		return user.map(UserDetailsImplementation::new).get();
		
	}

	

}
