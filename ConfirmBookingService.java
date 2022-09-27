package com.cts.homeservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.homeservice.model.AddService;
import com.cts.homeservice.model.Appointment;
import com.cts.homeservice.model.ConfirmBooking;
import com.cts.homeservice.model.UserRegistration;
import com.cts.homeservice.repository.AddServiceRepository;
import com.cts.homeservice.repository.AppointmentRepository;
import com.cts.homeservice.repository.ConfirmBookingRepository;
import com.cts.homeservice.repository.UserRegistrationRepository;

@Service
public class ConfirmBookingService {

	AddServiceRepository addServiceRepository;
	UserRegistrationRepository userRegistrationRepository;
	ConfirmBookingRepository confirmBookingRepository;
	AppointmentRepository appointmentRepository;

	@Autowired
	public ConfirmBookingService(AddServiceRepository addServiceRepository,
			UserRegistrationRepository userRegistrationRepository, ConfirmBookingRepository confirmBookingRepository,
			AppointmentRepository appointmentRepository) {
		super();
		this.addServiceRepository = addServiceRepository;
		this.userRegistrationRepository = userRegistrationRepository;
		this.confirmBookingRepository = confirmBookingRepository;
		this.appointmentRepository = appointmentRepository;
	}

	public ConfirmBooking confirmBooking(String vendorId, String customerId, String location, String service) {
		Random random = new Random();
		int id = random.nextInt(1000 + 1);
		UserRegistration user = userRegistrationRepository.findByEmail(customerId);
		AddService addService = addServiceRepository.findByVendorId(vendorId);
		ConfirmBooking confirmBooking = new ConfirmBooking();
		confirmBooking.setCustomerContactNumber(user.getPhoneNumber());
		confirmBooking.setCustomerId(customerId);
		confirmBooking.setCustomerName(user.getFirstName() + " " + user.getLastName());
		confirmBooking.setVendorContactNumber(addService.getContactNumber());
		confirmBooking.setServiceType(service);
		confirmBooking.setVendorId(vendorId);
		confirmBooking.setVendorName(addService.getName());
		confirmBooking.setStatus("Pending");
		confirmBooking.setAppointmentId(id);
		confirmBookingRepository.save(confirmBooking);
		
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(id);
		appointment.setCustomerName(user.getFirstName() + " " + user.getLastName());
		appointment.setCustomerNumber(user.getPhoneNumber());
		appointment.setIsPaid("Paid");
		appointment.setVendorId(vendorId);
		appointment.setWorkStatus("Pending");
		appointmentRepository.save(appointment);
		return confirmBooking;

	}

	public List<ConfirmBooking> getBookings(String name) {
		List<ConfirmBooking> bookings = confirmBookingRepository.findByCustomerId(name);
		return bookings;
		
	}

}
