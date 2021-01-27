package com.eauction.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eauction.model.Auction;
import com.eauction.model.Product;
import com.eauction.model.User;
import com.eauction.service.AuctionService;
import com.eauction.service.ProductService;

@Controller
public class ViewBidController {
	AuctionService auctionService = new AuctionService();
	
	List<Auction> bids;
	
	
	@RequestMapping( "/viewbid/{id}")
	public String getviewBid(@PathVariable("id")int product_id,HttpServletRequest req, Model m)
	{	
		
		int seller_id = ((User)req.getSession().getAttribute("user_object")).getId();
		bids = 	auctionService. findAllAuctionsdBySellerIdAndProductId(seller_id, product_id);


		m.addAttribute("bids_list",bids);
		m.addAttribute("active", false);
		System.out.println(bids);
		
		
		
		return "views/view_bid"; 
	}
	
	
	@RequestMapping(value =  "/viewbid/accept_bid/{id}", method=RequestMethod.GET)
	public void getAcceptBid(@PathVariable("id")int auction_id ,HttpServletRequest req, HttpServletResponse res, Model m) throws IOException
	{	
		
		for(int i=0;i<bids.size(); i++) {
			if(bids.get(i).getId() == auction_id) {
				bids.get(i).setStatus("Accepted");
				
			}else {
				bids.get(i).setStatus("Rejected");
			}
			auctionService.update(bids.get(i));
		}
		
		String mapping_string = req.getContextPath() + "/viewbid/" + bids.get(0).getProduct().getId();
		res.sendRedirect(mapping_string);
	
	}
}
