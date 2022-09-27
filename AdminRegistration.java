package com.cts.homeservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class AdminRegistration {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank(message = "First name should not be empty")
	private String firstName;
	
	@NotBlank(message = "Last name should not be empty")
	private String lastName;

	@Email
	@NotBlank(message = "Email should not be empty")
	private String email;
	
	@NotBlank(message = "Phone number should not be empty")
	private String phoneNumber;
	
	@NotBlank(message = "Password should be empty")
	private String password;
	
	public AdminRegistration() {
		super();
	}

	public AdminRegistration(String firstName,String lastName,String email,String phoneNumber,String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
