package com.example.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
	
	@GetMapping("/login")
	   public String login() {
	      return "login";
	   }

	   @GetMapping("/")
	   public String home() {
	      return "redirect:/index.html";
	   }
	
	   
	 

}
