package com.CRUD.customers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerControllerCRUD {

	//Annotations on parameters such as @RequestParam or @ModelAttribute("customer") are descriptive but not functional.
	//@RequestParam is to define the action of controller.
	
	//"Dao singleton service" (java bean object).
	@Autowired
	private CustomerService customerService;
	
	//I set the object which is going to save in "new_customer.jsp".
	@GetMapping("/new")
	public ModelAndView newCustomerForm(ModelAndView view, Optional<Customer> customer){ 
	  view = new ModelAndView("new_customer");
	  //view.addObject("customer",new Customer());
	  view.addObject("customer",customer.orElse(new Customer()));
	  //This container object set one value or another default value.
	  return view;
	  /* <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
	   * <form:form action="save" method="post" modelAttribute="customer">
	   */
	 }
	
	//I set and i send the object selected to edit_customer.jsp.
	@GetMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam(name = "id", required = true, defaultValue = "id")  long id, ModelAndView view){ 
	  //parameters in annotations are optional.
	  view = new ModelAndView("edit_customer");
	  Customer customer = this.customerService.getById(id);
	  view.addObject("customer",customer);
	  return view;	
       /* <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
	   * <form:form action="save" method="post" modelAttribute="customer">
	   */ 
	 }
	
	//Save object from Form and it returns to index.
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute(name = "customer") Customer customer){ 
	  this.customerService.save(customer);
	  return "redirect:/";	
    }
	
  	//I delete and the object and it returns to index(home).
	@GetMapping("/delete")
	public String deleteCustomerForm(@RequestParam("id") long id,@RequestParam("name") String name) {
	  //<a href="./delete?id=${customer.id}&name=${customer.name}">Delete</a> Action after query to find the search. (good tool to save favorites pages)
	  this.customerService.delete(id,name);
	  return "redirect:/"; //"redirect:/viewA/viewB..       
	}
}	
