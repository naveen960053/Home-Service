package com.cts.homeservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookService {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String userName;
	private String category;
	private String serviceName;
	private String location;
	
	public BookService() {
	}
	
	public BookService(String userName, String serviceName, String location, String issue) {
		this.userName = userName;
		this.serviceName = serviceName;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
