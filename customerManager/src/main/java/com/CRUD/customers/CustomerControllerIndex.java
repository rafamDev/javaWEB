package com.CRUD.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerControllerIndex {

	    //"Dao singleton service" (java bean object).
	    //Dependency injection.
		@Autowired
		private CustomerService customerService;
		
		@GetMapping()
		public ModelAndView index(ModelAndView mv) {
		  mv = new ModelAndView("index");
		  mv.addObject("listCustomer",this.customerService.listAll());
		  return mv;
		}
		//The model and view are resolved by the DispatcherServlet.
		//The String view is resolved by the ViewResolver object,  alternatively a View object can be specified directly. The model is a Map, allowing the use of multiple objects keyed by name. 
}
