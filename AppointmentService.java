package com.cts.homeservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.homeservice.model.Appointment;
import com.cts.homeservice.model.ConfirmBooking;
import com.cts.homeservice.repository.AppointmentRepository;
import com.cts.homeservice.repository.ConfirmBookingRepository;

@Service
public class AppointmentService {


	AppointmentRepository appointmentRepository;
	ConfirmBookingRepository confirmBookingRepository;
	
	@Autowired
	public AppointmentService(AppointmentRepository appointmentRepository,
			ConfirmBookingRepository confirmBookingRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
		this.confirmBookingRepository = confirmBookingRepository;
	}

	public List<Appointment> getAppointment(String vendorId) {
		List<Appointment> list = appointmentRepository.findAll();
		List<Appointment> list2 = new ArrayList<>();
		for (Appointment appointment : list) {
			if (appointment.getVendorId().equals(vendorId)) {
				if (appointment.getWorkStatus().equals("Pending")) {
					list2.add(appointment);
				}
			}
		}
		return list2;
	}

	public void closeService(int id) {
		
		Appointment appointment = appointmentRepository.findByAppointmentId(id);
		appointment.setWorkStatus("Completed");
		appointmentRepository.save(appointment);
		ConfirmBooking booking = confirmBookingRepository.findByAppointmentId(id);
		booking.setStatus("Completed");
		confirmBookingRepository.save(booking);
		
	}

}
