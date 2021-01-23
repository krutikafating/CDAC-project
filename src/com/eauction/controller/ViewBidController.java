package com.eauction.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eauction.model.Auction;
import com.eauction.model.Product;
import com.eauction.model.User;
import com.eauction.service.AuctionService;
import com.eauction.service.ProductService;

@Controller
public class ViewBidController {
	AuctionService auctionService = new AuctionService();
	
	@RequestMapping( "/viewbid")
	public String getviewBid(HttpServletRequest req, Model m)
	{	
		
		int seller_id = ((User)req.getSession().getAttribute("user_object")).getId();
		List<Auction> bids = 	auctionService. findAllAuctionsdBySellerId(seller_id);


		m.addAttribute("bids_list",bids);
		
//		int product_id = ((User)req.getSession().getAttribute("user_object")).getId();
//		List<Product> products = 	productService.findAllProductsdBySellerId(seller_id);
//
//
//		m.addAttribute("product_list",products);
		
		System.out.println(bids);
		
		
		
		return "views/view_bid"; 
	}
	
	
	
}
