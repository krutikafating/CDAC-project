package com.eauction.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

		@Controller
		public class AdminViewSellerController {

			@RequestMapping( "/sellers")
			public String getviewProduct()
			{	
				
				return "views/adminViewSellers"; 
			}
		}

		


	




