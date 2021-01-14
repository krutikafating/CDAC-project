package com.eauction.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewBidController {

	
	@RequestMapping( "/viewbid")
	public String getviewBid(HttpServletRequest req, Model m)
	{	
		
		return "views/view_bid"; 
	}
	
	
	
}
