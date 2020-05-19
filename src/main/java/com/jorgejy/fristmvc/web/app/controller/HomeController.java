package com.jorgejy.fristmvc.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
	
	// redirect reset petition
	// forward no reset petition and no redirect.
	
	@GetMapping("")
	public String home() {
		// return "redirect:/app/index";
		// return "redirect:https://www.google.com/";
		return "forward:/app/index"; // no reload page and no change path URL
		// forward the best to home page and only to page in the project
		// forward execute the dispatcher forward 
	}
}
