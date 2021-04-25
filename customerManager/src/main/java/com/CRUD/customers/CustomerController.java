package com.CRUD.customers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	//"Dao singleton" (java bean object).
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
	
	//Open view /new and set what object is going to save and return where (jsp file).
	@RequestMapping("/new")
	public String newCustomerForm(Map<String,Object> model){ 
		model.put("customer", new Customer()); //@ModelAttribute("customer") Customer customer
	  return "new_customer"; 
	}
	
	//Save object from Form in view "/new" and goes back to index (home).
	//The action of the form is called "Save".
	@RequestMapping(value= "/save", method= RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer){ 
		this.customerService.save(customer);
	  return "redirect:/";	
    }
	
	@RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam long id){ 
		ModelAndView model = new ModelAndView("edit_customer");
		Customer customer = this.customerService.getById(id);
		model.addObject("customer",customer);
	  return model;	
    }
	
	@RequestMapping("/delete")
	public String deleteCustomerForm(@RequestParam long id) {
	    this.customerService.delete(id);
	  return "redirect:/";       
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
	    List<Customer> result = customerService.search(keyword);
	    ModelAndView mav = new ModelAndView("search");
	    mav.addObject("result", result);
	 
	    return mav;    
	}
}
