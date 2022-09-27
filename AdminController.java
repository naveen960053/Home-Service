package com.cts.homeservice.controller;

import javax.validation.Valid;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.homeservice.model.AdminRegistration;
import com.cts.homeservice.model.ConfirmBooking;
import com.cts.homeservice.model.CustomerReview;
import com.cts.homeservice.service.AdminManagement;
import com.cts.homeservice.service.AdminRegistrationService;

@Controller
@RequestMapping("/admin") 
public class AdminController {

	AdminRegistrationService adminRegistrationService;
	AdminManagement adminManagement;
	
	@Autowired
	public AdminController(AdminRegistrationService adminRegistrationService,AdminManagement adminManagement) {
		super();
		this.adminRegistrationService = adminRegistrationService;
		this.adminManagement=adminManagement;
	}

	@GetMapping("/login")
	public String showLogin()
	{
		return "adminLogin";
	}
	
	@GetMapping("/register")
	public String showRegister(@ModelAttribute("AdminRegistration") AdminRegistration admin)
	{
		return "adminRegister";
	}

	@PostMapping("/register")
	public String registerAdmin(@Valid @ModelAttribute("AdminRegistration") AdminRegistration admin,BindingResult result)
	{
		if(result.hasErrors())
			return "adminRegister";
		adminRegistrationService.createAdmin(admin);
		return "adminLogin";
	}
	
	@GetMapping("/home")
	public String onlyAdmin()
	{
		return "adminHome";
	}
	
	@GetMapping("/viewreview")
	public String showReview(Model model)
	{
		List<CustomerReview> reviews = adminManagement.getReview();
		model.addAttribute("review", reviews);
		return "viewReview";
	}
	
	@GetMapping("/generateReview")
	public String generatereview(Model model)
	{
		adminManagement.generateReview();
		
		return "adminHome";
	}
	
	@GetMapping("/report")
	public String getReport(Model model)
	{
		List<ConfirmBooking> report = adminManagement.getReport();
		model.addAttribute("report", report);
		return "viewReport";
	}
	
	@GetMapping("/generateReport")
	public String generateReport(Model model)
	{
		adminManagement.generateReport();
		
		return "adminHome";
	}
	

	

}
