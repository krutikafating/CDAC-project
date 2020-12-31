package com.eauction.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BidController {

	@RequestMapping( "/apply_bid")
	public String getBidAmount()
	{	
		
		return "views/apply_for_bid"; 
	}
	
	@RequestMapping(value = "/bid_action_product", method = RequestMethod.POST)
	public void registerUser(
			@RequestParam("bid_username") String bidUname,
			@RequestParam("bid_product") String bidProduct,
			@RequestParam("bid_details") String bidDetails,
			@RequestParam("bid_owner") String bidOwner,
			@RequestParam("bid_bidAmount") String bidAmount,
			HttpServletRequest req, 
			HttpServletResponse res) 
			throws IOException {
		
		res.sendRedirect("dashboard_user");
	}
}