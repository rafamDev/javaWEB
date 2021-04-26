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

	//"Dao singleton service" (java bean object).
	@Autowired
	private CustomerService customerService;
	
	//Action "/default".
    //I set the list of objects.
	@RequestMapping("/")
	public ModelAndView home() {
		 ModelAndView modelAndView = new ModelAndView("index");
		 List<Customer> listCustomer = this.customerService.listAll();
		 modelAndView.addObject("listCustomer",listCustomer);
	  return modelAndView;
	}
	
	//Action (doGET) "/new".
	//I set the object which is going to save in "new_customer.jsp".
	@RequestMapping("/new")
	public String newCustomerForm(Map<String,Object> model){ 
		model.put("customer", new Customer()); //@ModelAttribute("customer") Customer customer
	  return "new_customer"; 
	}
	
	//Action (doPOST) "/save".
	//Save object from Form and it returns to index (home).
	@RequestMapping(value= "/save", method= RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer){ 
		this.customerService.save(customer);
	  return "redirect:/";	
    }
	
	//Action (doPOST) "/edit".
	//I set and i send the object selected to edit_customer.jsp.
    @RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam long id){ 
		ModelAndView model = new ModelAndView("edit_customer");
		Customer customer = this.customerService.getById(id);
		model.addObject("customer",customer);
	  return model;	
    }
	
    //Action (doGET) "/delete".
  	//I delete and the object and it returns to index(home).
	@RequestMapping("/delete")
	public String deleteCustomerForm(@RequestParam long id) {
	    this.customerService.delete(id);
	  return "redirect:/";       
	}
	
	//Action (doGET) "/search".
    //I set the objects selected.
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
	    List<Customer> result = customerService.search(keyword);
	    ModelAndView mav = new ModelAndView("search");
	    mav.addObject("result", result);
	  return mav;    
	}
}
