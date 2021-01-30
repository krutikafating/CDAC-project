package com.eauction.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactUsController {

	
	@RequestMapping("/contact")
	public String getContactUs()
	{
		return "views/ContactUs";
	}
	
	@RequestMapping("/contact_us_action")
	public String getContact()
	{
		return "views/auctionheader";
	}
}
