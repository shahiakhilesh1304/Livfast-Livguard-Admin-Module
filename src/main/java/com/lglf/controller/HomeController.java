package com.lglf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController 
{
	private static final Logger log = LoggerFactory.getLogger(SchemeController.class);
	
	
	@GetMapping({"/", "/home"})
	public String showHome(Model model) 
	{
		log.info("Home Controller....");
		return "index";
	}
	
}
