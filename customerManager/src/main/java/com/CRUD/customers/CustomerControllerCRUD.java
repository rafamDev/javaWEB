package com.CRUD.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerControllerCRUD {

	//Annotations on parameters such as @RequestParam or @ModelAttribute("customer") are descriptive but not functional.
	//@RequestParam is to define the action of controller.
	
	//"Dao singleton Service" (java bean object).
	//Dependency injection.
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("new")
	public ModelAndView newCustomerForm(ModelAndView mv){ 
	  mv = new ModelAndView("new_customer"); //Add View
	  mv.addObject("customer",new Customer()); //Add Model
	  return mv; //return view + model.
	  /* <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
	   * <form:form action="save" method="post" modelAttribute="customer">
	   */
	 }
	
	@PostMapping("save")
	public String saveCustomerForm(Customer customer){ 
	   this.customerService.save(customer);
	   return "redirect:"; 
	}
			
	@GetMapping("edit")
	public ModelAndView editCustomerForm(@RequestParam(name = "id", required = true, defaultValue = "id")  long id, ModelAndView mv){ 
	  //parameters in annotations are optional.
	  mv = new ModelAndView("edit_customer");
	  mv.addObject("customer",this.customerService.getById(id));
	  return mv;	
       /* <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
	   * <form:form action="save" method="post" modelAttribute="customer">
	   */ 
	 }
	
	@GetMapping("delete")
	public String deleteCustomerForm(@RequestParam("id") long id,@RequestParam("name") String name) {
	  //<a href="./delete?id=${customer.id}&name=${customer.name}">Delete</a> Action after query to find the search. (good tool to save favorites pages)
	  this.customerService.delete(id,name);
	  return "redirect:"; //"redirect:/addressA/addressB..       
	}
}	
