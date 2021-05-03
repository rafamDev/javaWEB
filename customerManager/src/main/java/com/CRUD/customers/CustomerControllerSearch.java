package com.CRUD.customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerControllerSearch {

	//"Dao singleton service" (java bean object).
	@Autowired
	private CustomerService customerService;
	
	//I set the objects selected. 
	@GetMapping("/search")
	public ModelAndView search(@RequestParam(name = "keyword", required = true, defaultValue = "Keyword") String keyword, ModelAndView mv){
      mv = new ModelAndView("search");
      mv.addObject("result",  this.customerService.search(keyword));
	  return mv; 
	  /*<form method="get" action="search">
	   <input type="text" name="keyword"/> &nbsp;
	   <input type="submit" value="Search"/>
	   </form>*/
	}
		
}
