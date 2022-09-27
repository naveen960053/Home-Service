package com.cts.homeservice.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.homeservice.model.Payment;
import com.cts.homeservice.repository.PaymentRepository;

@Service
public class PaymentService {
	
	PaymentRepository paymentRepository;

	@Autowired
	public PaymentService(PaymentRepository paymentRepository) {
		super();
		this.paymentRepository = paymentRepository;
	}
	
	public int getPrice(String service)
	{
		int amount=0;
		Map<String,Integer> map = new LinkedHashMap<>();
		map.put("Electrician", 250);
		map.put("Plumber", 200);
		map.put("Carpenter", 500);
		map.put("AC",400);
		map.put("TV", 250);
		map.put("Salon and Makeup Services", 450);
		map.put("Room Cleaning", 300);
		map.put("Drinage",350);
		amount = map.get(service);
		return amount;
	}
	
	public void createPayment(Payment payment)
	{
		paymentRepository.save(payment);
	}
	
	

}
