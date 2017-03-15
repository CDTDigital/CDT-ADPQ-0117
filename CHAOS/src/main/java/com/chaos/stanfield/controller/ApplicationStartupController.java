package com.chaos.stanfield.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chaos.stanfield.utils.JPAInitEMF;

@Controller
public class ApplicationStartupController {

	  @RequestMapping("/")
	   public String welcome(Model model) {
		  return "index";
	   }
	 	  
	  @RequestMapping("/home")
	   public String home(Model model) {
		  return "home";
	   }
	  
	  @RequestMapping("/header")
	   public String header(Model model) {
		  return "header";
	   }
	  
	   @RequestMapping("/footer")
	   public String footer(Model model) {
		  return "footer";
	   }
	  
	  
}
