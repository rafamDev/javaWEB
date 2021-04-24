package com.CRUD.customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	//"Dao singleton" (java bean object) is called here to send it to a view file.
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		 ModelAndView modelAndView = new ModelAndView("index");
		 List<Customer> listCustomer = this.customerService.listAll();
		 System.out.println(listCustomer.toString());
		 modelAndView.addObject("listCustomer",listCustomer);
	  
	  return modelAndView;
	}
	
}
