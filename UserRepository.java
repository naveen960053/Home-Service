package com.cts.homeservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.homeservice.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByUserName(String userName);
}
