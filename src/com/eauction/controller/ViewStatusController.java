package com.eauction.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	public class ViewStatusController {

		@RequestMapping( "/status")
		public String getviewStatus()
		{	
			
			return "views/view_status"; 
		}
	}


