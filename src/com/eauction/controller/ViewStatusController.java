package com.eauction.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eauction.model.Auction;
import com.eauction.model.Product;
import com.eauction.model.User;
import com.eauction.service.AuctionService;

	@Controller
	public class ViewStatusController {
		
		AuctionService auctionService = new AuctionService();
		


		@RequestMapping( "/status")
		public String getviewStatus(HttpServletRequest req, Model m)
		{	
			
			int buyer_id = ((User)req.getSession().getAttribute("user_object")).getId();
			List<Auction> status = 	auctionService.findAllProductsdByBuyerId(buyer_id);


			m.addAttribute("status_list",status);
			System.out.println(status);
			
			return "views/view_status"; 
		}
	}


