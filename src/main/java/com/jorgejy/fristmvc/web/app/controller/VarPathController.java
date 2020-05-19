package com.jorgejy.fristmvc.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/var")
public class VarPathController {
	
	@GetMapping("/")
	public String index() {
		return "var/index";
	}
	
	@GetMapping("/string/{text}")
	public String variables(@PathVariable String text,Model model) {
		model.addAttribute("valueparam", text);
		return "var/show";
	}
	
	@GetMapping("/string/{text}/{number}")
	public String variables(@PathVariable String text,@PathVariable int number,Model model) {
		model.addAttribute("valueparam", text + " número: "+number);
		return "var/show";
	}
}
