package com.eauction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewProController {

	@RequestMapping( "/view_product")
	public String getviewProduct()
	{	
		
		return "views/view_product"; 
	}
}
