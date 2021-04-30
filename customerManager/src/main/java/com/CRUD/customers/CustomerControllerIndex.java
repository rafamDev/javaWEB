package com.CRUD.customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerControllerIndex {

	//"Dao singleton service" (java bean object).
		@Autowired
		private CustomerService customerService;
		
		//I set the list of objects.
		@GetMapping("/")
		public ModelAndView index(ModelAndView view) {
		  view = new ModelAndView("index");
		  List<Customer> listCustomer = this.customerService.listAll();
		  view.addObject("listCustomer",listCustomer);
		  //With Model in SpringBoot it would be model.addAttribute("listCustomer",listCustomer); 
		  return view;
		}
}
