package com.cts.homeservice.controller;

import java.security.Principal;
import java.util.*;

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
import com.cts.homeservice.model.Appointment;
import com.cts.homeservice.model.CategoryRegistration;
import com.cts.homeservice.model.VendorRegistration;
import com.cts.homeservice.service.AddServiceService;
import com.cts.homeservice.service.AppointmentService;
import com.cts.homeservice.service.ServiceRegistrationService;
import com.cts.homeservice.service.VendorRegistrationService;

@Controller
@RequestMapping("/vendor")
public class VendorController {

	VendorRegistrationService vendorRegistrationService;
	ServiceRegistrationService serviceRegistrationService;
	AppointmentService appointmentService;
	AddServiceService addServiceService;

	@Autowired
	public VendorController(VendorRegistrationService vendorRegistrationService,
			ServiceRegistrationService serviceRegistrationService, AddServiceService addServiceService,
			AppointmentService appointmentService) {
		super();
		this.vendorRegistrationService = vendorRegistrationService;
		this.serviceRegistrationService = serviceRegistrationService;
		this.addServiceService = addServiceService;
		this.appointmentService=appointmentService;
	}

	@GetMapping("/login")
	public String showLogin() {
		return "vendorLogin";
	}

	@GetMapping("/register")
	public String showRegister(@ModelAttribute("VendorRegistration") VendorRegistration vendor) {
		return "vendorRegister";
	}

	@PostMapping("/register")
	public String registerVendor(@Valid @ModelAttribute("VendorRegistration") VendorRegistration vendor,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "vendorRegister";
		}
		String userName = vendorRegistrationService.createUser(vendor);
		model.addAttribute("user", userName);
		System.out.println(userName);
		return "vendorLogin";
	}

	@GetMapping("/role/home")
	public String showVendorHome() {
		return "vendorHome";
	}

	@GetMapping("/role/addservice")
	public String showAddService(@ModelAttribute("AddService") AddService addService, Model model) {
		List<CategoryRegistration> serviceList = serviceRegistrationService.getService();
		List<String> serviceName = new ArrayList<>();
		for (CategoryRegistration s : serviceList) {
			serviceName.add(s.getCategory());
		}
		model.addAttribute("categoryList", serviceName);

		return "addService";
	}

	@PostMapping("/role/addservice")
	public String addService(@ModelAttribute("AddService") AddService addService, Model model, Principal principal) {
		addServiceService.createService(addService, principal.getName());
		return "vendorHome";
	}

	@GetMapping("/role/addcategory")
	public String showAddCategory(@ModelAttribute("AddCategory") CategoryRegistration service, Model model) {
		return "addCategory";
	}

	@PostMapping("/role/addcategory")
	public String addCategory(@ModelAttribute("AddCategory") CategoryRegistration service) {
		serviceRegistrationService.addService(service);
		return "vendorHome";
	}

	@GetMapping("/role/appointment")
	public String showAppointment(Model model,Principal principal) {
		List<Appointment> appointments = appointmentService.getAppointment(principal.getName());
		model.addAttribute("appointment", appointments);
		return "appointment";
	}
	
	@GetMapping("/close/{id}")
	public String closeAppointment(@PathVariable("id") int id)
	{
		appointmentService.closeService(id);
		return "redirect:/vendor/role/appointment";
	}
	
	@GetMapping("/role/profile")
	public String showProfile(Model model, Principal principal) {
		AddService service = addServiceService.getProfile(principal.getName());
		model.addAttribute("vendor", service);
		return "vendorProfile";
	}

	@ModelAttribute("genderList")
	public List<String> populateGender() {
		List<String> list = new ArrayList<>();
		list.add("MALE");
		list.add("FEMALE");
		return list;
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
