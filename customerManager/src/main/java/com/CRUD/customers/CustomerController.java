package com.CRUD.customers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	//I set the list of objects.
	//@RequestMapping("/")
	@GetMapping("/")
	public ModelAndView index(ModelAndView view) {
		 view = new ModelAndView("index");
		 List<Customer> listCustomer = this.customerService.listAll();
		 view.addObject("listCustomer",listCustomer);
	  return view;
	}
	
	//I set the objects selected.
	@GetMapping("/search")
	public ModelAndView search(@RequestParam String keyword){
	  List<Customer> result = customerService.search(keyword);
	  ModelAndView mav = new ModelAndView("search");
	  mav.addObject("result", result);
	  return mav; 
	  /*<form method="get" action="search">
      <input type="text" name="keyword"/> &nbsp;
      <input type="submit" value="Search"/>
      </form>*/
	}
	
	//I set the object which is going to save in "new_customer.jsp".
	@GetMapping("/new")
	public ModelAndView newCustomerForm(ModelAndView view){ 
	  view = new ModelAndView("new_customer");
	  Customer customer = new Customer();
	  view.addObject("customer",customer);
	  return view;
	  /* <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
	   * <form:form action="save" method="post" modelAttribute="customer">
	   */
	 }
	
	//Action (doPOST) "/edit".
	//I set and i send the object selected to edit_customer.jsp.
	@RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam long id){ 
	  ModelAndView view = new ModelAndView("edit_customer");
	  Customer customer = this.customerService.getById(id);
	  view.addObject("customer",customer);
	  return view;	
      /* <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
	  * <form:form action="save" method="post" modelAttribute="customer">
	  * */
	 }
	
	//Action (doPOST) "/save".
	//Save object from Form and it returns to index.
	@RequestMapping(value= "/save", method= RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("custome") Customer customer){ 
	  this.customerService.save(customer); //view.addObject("customer",customer); -> @ModelAttribute("customer") -> ${customer}
	  return "redirect:/";	
    }
	
	//Action (doGET) "/delete".
  	//I delete and the object and it returns to index(home).
	@GetMapping("/delete")
	public String deleteCustomerForm(@RequestParam long id) {
	  this.customerService.delete(id);
	  return "redirect:/"; //"redirect:/viewA/viewB..      
	}

}	
