package com.cts.homeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.homeservice.model.ConfirmBooking;

public interface ConfirmBookingRepository extends JpaRepository<ConfirmBooking, Integer> {

	List<ConfirmBooking> findByCustomerId(String name);

	ConfirmBooking findByAppointmentId(int id);
	
}
