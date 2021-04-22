package com.springTest3.springTest3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller1 {

	//Http -> GET request.
	@GetMapping("/")
	public String getWelcome(Model model){
		//Model is interface of a hashmap K V.
		model.addAttribute("message", "this is a model message");
		return "index";
	}

}
