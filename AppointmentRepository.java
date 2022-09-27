package com.cts.homeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.homeservice.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	Appointment findByAppointmentId(int id);

}
