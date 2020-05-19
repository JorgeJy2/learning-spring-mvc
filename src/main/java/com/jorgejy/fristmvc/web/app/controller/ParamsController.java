package com.jorgejy.fristmvc.web.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {

	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(required = false, defaultValue = "No name") String text, Model model) {
		model.addAttribute("valueparam", "Valor enviado: "+text);
		return "params/show";
	}

	@GetMapping("/mix-param")
	public String param(@RequestParam String greeting,@RequestParam int number, Model model) {
		model.addAttribute("valueparam", "Saludo : "+greeting + " número: "+ number);
		return "params/show";
	}
	
	@GetMapping("/mix-param-request")
	public String param(HttpServletRequest request, Model model) {
		String greeting = request.getParameter("greeting");
		int number = 0;
		try {
			number =Integer.parseInt( request.getParameter("number"));			
		} catch (Exception e) {
			number = 0;
		}
		model.addAttribute("valueparam", "Saludo : "+greeting + " número: "+ number);
		return "params/show";
	}
}
