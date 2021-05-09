package com.customerManagerBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customerManagerBoot.entity.Customer;
import com.customerManagerBoot.service.ICustomerService;


//@RequestMapping("/webFiles/customers")
@Controller
public class CustomerController {
	
	 @Autowired
	 private ICustomerService service;


	@GetMapping("/webFiles/customers/list")
	public String listCustomers(Model model) {
		model.addAttribute("title","List of customers");
		model.addAttribute("listCustomers",this.service.listAll());
		return "/webFiles/customers/list";
	}
	
	@GetMapping("/webFiles/customers/list/create")
	public String createCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		
		return "/webFiles/customers/create";
	}
}
