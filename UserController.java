package com.cts.homeservice.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.homeservice.model.AddService;
import com.cts.homeservice.model.BookService;
import com.cts.homeservice.model.ConfirmBooking;
import com.cts.homeservice.model.CustomerReview;
import com.cts.homeservice.model.Payment;
import com.cts.homeservice.model.CategoryRegistration;
import com.cts.homeservice.model.UserRegistration;
import com.cts.homeservice.repository.BookServiceRepository;
import com.cts.homeservice.service.BookingService;
import com.cts.homeservice.service.ConfirmBookingService;
import com.cts.homeservice.service.PaymentService;
import com.cts.homeservice.service.AdminManagement;
import com.cts.homeservice.service.ServiceRegistrationService;
import com.cts.homeservice.service.UserRegistrationService;
import com.cts.homeservice.service.UsersSercice;

@Controller
public class UserController {

	ServiceRegistrationService serviceRegistrationService;
	ConfirmBookingService confirmBookingService;
	BookingService bookingService;
	UserRegistrationService registrationService;
	UsersSercice userService;
	AdminManagement reviewService;
	PaymentService paymentService;

	@Autowired
	public UserController(UserRegistrationService registrationService, UsersSercice userService,
			ServiceRegistrationService serviceRegistrationService, BookingService bookingService,
			ConfirmBookingService confirmBookingService, AdminManagement reviewService, PaymentService paymentService) {
		this.registrationService = registrationService;
		this.userService = userService;
		this.serviceRegistrationService = serviceRegistrationService;
		this.bookingService = bookingService;
		this.confirmBookingService = confirmBookingService;
		this.reviewService = reviewService;
		this.paymentService = paymentService;
	}

	@GetMapping("/user/showMyLoginPage")
	public String showLogin() {
		return "Homeservice";
	}

	@GetMapping("/user/login")
	public String showUser() {
		return "userLogin";
	}

	@GetMapping("/user/register")
	public String showRegister(@ModelAttribute("UserRegistration") UserRegistration user) {
		return "userRegister";
	}

	@PostMapping("/user/register")
	public String registerUser(@Valid @ModelAttribute("UserRegistration") UserRegistration user, BindingResult result) {
		if (result.hasErrors()) {
			return "userRegister";
		}
		registrationService.createUser(user);
		return "redirect:/user/login";
	}

	@GetMapping("/user/role/bookservice")
	public String showBookService(@ModelAttribute("bookService") BookService bookService, Model model) {
		List<CategoryRegistration> serviceList = serviceRegistrationService.getService();
		List<String> serviceName = new ArrayList<>();
		for (CategoryRegistration s : serviceList) {
			serviceName.add(s.getCategory());
		}
		model.addAttribute("categoryList", serviceName);
		return "bookService";
	}

	@PostMapping("/user/role/bookservice")
	public String bookService(@ModelAttribute("bookService") BookService bookService, Principal principal,
			Model model) {
		bookService.setUserName(principal.getName());
		bookingService.bookService(bookService);
		List<AddService> addService = bookingService.getVendor(bookService);
		model.addAttribute("serviceList", addService);
		return "bookServiceResponse";
	}

	@GetMapping("/user/role/book/{id}/{location}/{service}")
	public String book(@PathVariable("id") String userName, @PathVariable("service") String serviceType,
			@PathVariable("location") String location, Principal principal, Model model) {
		ConfirmBooking confirmBooking = confirmBookingService.confirmBooking(userName, principal.getName(), location,
				serviceType);
		model.addAttribute("booking", confirmBooking);
		return "confirmBooking";

	}

	@GetMapping("/user/role/mybooking")
	public String showMyBookings(Model model, Principal principal) {
		List<ConfirmBooking> bookings = confirmBookingService.getBookings(principal.getName());
		model.addAttribute("booking", bookings);
		return "myBookings";
	}

	@GetMapping("/user/role/review")
	public String showReview(Model model, @ModelAttribute("customerReview") CustomerReview review) {
		return "customerReview";
	}

	@PostMapping("/user/role/review")
	public String addReview(Model model, Principal principal, @ModelAttribute("customerReview") CustomerReview review) {

		reviewService.addReview(review, principal.getName());
		model.addAttribute("msg", "yes");
		return "customerReview";
	}

	@GetMapping("/user/role/payment/{type}/{id}")
	public String payment(Model model, Principal principal, @ModelAttribute("payment") Payment payment,
			@PathVariable("type") String service, @PathVariable("id") int id) {
		int amount = paymentService.getPrice(service);
		model.addAttribute("id", id);
		model.addAttribute("amount", amount);
		return "payment";
	}

	@PostMapping("/user/role/payment/{id}/{amount}")
	public String proceedPayment(Model model, Principal principal, @ModelAttribute("payment") Payment payment,
			@PathVariable("id") int id,@PathVariable("amount") int amount) {
		payment.setAppointmentId(id);
		payment.setTotalAmount(amount);
		paymentService.createPayment(payment);
		return "userHome";
	}

	@GetMapping("/user/access-denied")
	public String showAccessDenied(Principal p, Model model) {
		model.addAttribute("userName", p.getName());
		return "accessdenied";
	}

	@GetMapping("/")
	public String showAccessDenie(Principal p, Model model) {
		String userName = p.getName();
		String authority = userService.getAuthority(userName);
		if (authority.equals("VENDOR")) {
			return "vendorHome";
		}
		if (authority.equals("USER")) {
			return "userHome";
		}
		if (authority.equals("ADMIN")) {
			return "adminHome";
		}
		model.addAttribute("userName", p.getName());
		return "userHome";
	}

	@ModelAttribute("locationList")
	public List<String> populateLocation() {
		List<String> list = new ArrayList<>();
		list.add("Select your location");
		list.add("Chennai");
		list.add("Dindugul");
		list.add("Coimbatore");
		list.add("Trichy");
		list.add("Madurai");
		list.add("Namakkal");
		return list;
	}

	@ModelAttribute("serviceList")
	public List<String> populateService() {
		List<String> list = new ArrayList<>();
		list.add("Select your Service");
		list.add("Electrician");
		list.add("Plumber");
		list.add("Carpenter");
		list.add("AC");
		list.add("TV");
		list.add("Salon and Makeup Services");
		list.add("Room Cleaning");
		list.add("Drinage");
		return list;
	}

}
