package com.cts.homeservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategoryRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String service;

	public CategoryRegistration() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return service;
	}

	public void setCategory(String category) {
		this.service = category;
	}
	

}
