package com.cts.homeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.homeservice.model.CustomerReview;

public interface CustomerReviewRepository extends JpaRepository<CustomerReview, Integer> {

}
