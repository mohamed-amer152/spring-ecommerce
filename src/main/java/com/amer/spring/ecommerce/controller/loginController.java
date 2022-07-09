package com.amer.spring.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.amer.spring.ecommerce.entity.authority;
import com.amer.spring.ecommerce.entity.user;
import com.amer.spring.ecommerce.services.authorityService;
import com.amer.spring.ecommerce.services.userService;

@Controller
public class loginController {
	
	@Autowired
	private userService Uservice;
	@Autowired
	private authorityService auService ;
	
	@GetMapping("/showlogin")
	public String login( Model model)
	{ 
		user u = new user();
		model.addAttribute("user", u);
		return "login" ;
	}

	@GetMapping("/register")
	public String register(Model model)
	{
		user u = new user();
		authority aut = new authority();
		model.addAttribute("authority", aut);
		model.addAttribute("user", u);
		return "register";
	}
	
	@PostMapping("/saveUser")
	public String saveuser(@ModelAttribute user u , @ModelAttribute authority aut)
	{
		user test= Uservice.search(u.getUsername());
		if (test == null) {
			
			aut.setUsername(u.getUsername());
			u.setPassword("{noop}"+u.getPassword());
			Uservice.save(u);
			auService.save(aut);
			return "login";
			
		} else {
            return null ;
		}
		
	}
	
}
