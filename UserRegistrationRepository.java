package com.cts.homeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.homeservice.model.UserRegistration;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer> {

	UserRegistration findByEmail(String customerId);

}
