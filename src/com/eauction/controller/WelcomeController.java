package com.eauction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	public WelcomeController() {
		System.out.println("\n\n--Welcome Auction Controller Initialized in eauction--\n\n");
		welcomePage();
	}
	
	
	@RequestMapping("/welcome")
	public String welcomePage()
	{
		System.out.println("welcomePage");
		return "index";
	}
}
