package com.jorgejy.fristmvc.web.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorgejy.fristmvc.web.app.model.User;

@Controller
// level 1
@RequestMapping("/app") // First /
public class IndexController {
	
	// this need application.properties values.
	@Value("${index.root.title}")
	private String titleIndex;
	@Value("${index.profile.title}")
	private String titleProfile;
	@Value("${index.list.title}")
	private String titleList;
	

	// Method handler only use 1 template
	// @RequestMapping(value="/index", method = RequestMethod.GET) // First / method default GET
	// only path @GetMapping("/index")
	@GetMapping({ "/index", "/", "/home", ""}) // multiple path
	// ModelMap implements LinkedHashMap JAVA API 
	// Map<String, Object>
	// ModelAndView 
		// method addObject
		// return ModelAndView
		// setViewName("nameTEMPLATE")
	public String index(Model model) {
		model.addAttribute("title",titleIndex);
		return "index"; // need index.html in template 
	} 
	
	@RequestMapping("/profile")
	public String profile(Model model) {
		User user = new User();
		user.setName("Jorge");
		user.setFirstName("Jacobo");
		user.setEmail("jorge@email.com");
		model.addAttribute("user", user);
		model.addAttribute("title", titleProfile.concat(user.getName()));
		return "profile";
	}
	
	@GetMapping("list")
	public String list (Model model) {
		model.addAttribute("title", titleList);
		// model.addAttribute("users", users);
		return "list";
	}
	
	@ModelAttribute("users")
	public List<User> getUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User("Jorge", "Jacobo", "Jorge@gmail.com"));
		users.add(new User("Amanda", "Franco", "Amanda@gmail.com"));
		users.add(new User("Alexis", "Zamudio", "Alexis@gmail.com"));
		return users;
	}
}
