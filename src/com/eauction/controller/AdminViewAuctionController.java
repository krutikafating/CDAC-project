package com.eauction.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

		@Controller
		public class AdminViewAuctionController {

			@RequestMapping( "/auctions")
			public String getviewProduct()
			{	
				
				return "views/adminViewAuction"; 
			}
		}

		


	
	

