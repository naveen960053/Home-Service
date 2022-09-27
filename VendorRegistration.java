package com.cts.homeservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class VendorRegistration {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotBlank(message = "First name should not be empty")
	private String firstName;
	
	@NotBlank(message = "Last name should not be empty")
	private String lastName;
	
	@NotNull(message = "Age should not be empty")
	@Min(value = 18,message = "Age must be greater than equal to 18")
	private int age;
	
	private String gender;
	
	@Email
	@NotBlank(message = "Email should not be empty")
	private String email;
	
	@NotBlank(message = "Phone number should not be empty")
	private String phoneNumber;
	
	@NotBlank(message = "Password should be empty")
	private String password;

	public VendorRegistration() {

	}

	public VendorRegistration(String firstName, String lastName, int age,String gender, String email, String phoneNumber,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender=gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
