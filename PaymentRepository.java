package com.cts.homeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.homeservice.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
