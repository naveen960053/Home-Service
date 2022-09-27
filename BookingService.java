package com.cts.homeservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.homeservice.model.AddService;
import com.cts.homeservice.model.BookService;
import com.cts.homeservice.repository.AddServiceRepository;
import com.cts.homeservice.repository.BookServiceRepository;

@Service
public class BookingService {

	BookServiceRepository bookServiceRepository;
	AddServiceRepository addServiceRepository;

	@Autowired
	public BookingService(BookServiceRepository bookServiceRepository, AddServiceRepository addServiceRepository) {
		super();
		this.bookServiceRepository = bookServiceRepository;
		this.addServiceRepository = addServiceRepository;
	}

	public void bookService(BookService service) {
	
		bookServiceRepository.save(service);
	}

	public List<AddService> getVendor(BookService bookService) {
		List<AddService> vendorList1 = addServiceRepository.findByLocation(bookService.getLocation());
		List<AddService> vendorList2 = new ArrayList<>();
		for (AddService addService : vendorList1) {
			if (addService.getServiceCategory().equals(bookService.getServiceName())) {
				if (addService.getCategory().equals(bookService.getCategory())) {
					vendorList2.add(addService);
				}
			}
		}
		return vendorList2;
	}

}
