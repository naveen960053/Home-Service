package com.cts.homeservice.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cts.homeservice.model.Users;

public class UserDetailsImplementation implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private boolean isActive;
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImplementation() {
	}

	public UserDetailsImplementation(Users user) {
		super();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.isActive = user.isActive();
		this.authorities = Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		System.out.println("User Name : "+userName);
		System.out.println("This is"+authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return isActive;
	}

}
/*
$2a$10$67j84rBKmxORar9HHSXZIegESPawVD5MHVYyL2RwP7g7ETpipRFZC
$2a$10$67j84rBKmxORar9HHSXZIegESPawVD5MHVYyL2RwP7g7ETpipRFZC
*/
