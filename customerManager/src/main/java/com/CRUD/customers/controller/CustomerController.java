package com.CRUD.customers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	@RequestMapping("/")
	public ModelAndView home() {
		 ModelAndView modelAndView = new ModelAndView("index");
		 modelAndView.addObject("message","Hello Spring MVC");
	  return modelAndView;
	}
	
}
