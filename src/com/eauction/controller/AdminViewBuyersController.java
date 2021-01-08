package com.eauction.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	public class AdminViewBuyersController {

		@RequestMapping( "/buyers")
		public String getviewProduct()
		{	
			
			return "views/adminViewBuyers"; 
		}
	}

	

