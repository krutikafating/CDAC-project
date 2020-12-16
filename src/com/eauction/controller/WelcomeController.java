package com.eauction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	public WelcomeController() {
		System.out.println("\n\n--Welcome Auction Controller Initialized--\n\n");
	}
	
	
	@RequestMapping("/welcome")
	public String welcomePage()
	{
		return "index.jsp";
	}
}
