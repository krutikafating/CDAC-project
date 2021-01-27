package com.eauction.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eauction.model.Auction;
import com.eauction.model.Product;
import com.eauction.model.User;
import com.eauction.service.AuctionService;
import com.eauction.service.ProductService;

@Controller
public class AuctionController {
	
	
	ProductService productService = new ProductService();
	AuctionService auctionService = new AuctionService();
	Product targetted_product ; //defined global variable for product id
	User targetted_seller;
	User targetted_buyer;
	//Add Auction action
	
			@RequestMapping( "/add_auctions")
			public String getauctionProduct(HttpServletRequest req, Model m)
			{	

				int seller_id = ((User)req.getSession().getAttribute("user_object")).getId();

				List<Product> products = 	productService.findAllProductsOtherThanSellerId(seller_id);


				m.addAttribute("product_list_auction",products);
				
			
				
				return "views/auction"; 
			}
			
	@RequestMapping(value = "/apply_bid/{id}", method=RequestMethod.GET)	
	public String getBidAmount(@PathVariable("id")int id, HttpServletRequest req,  Model m)
	{	

		Product product = productService.findById(id);
		targetted_product = product;
		targetted_seller = product.getSeller();
		targetted_buyer = ((User)req.getSession().getAttribute("user_object"));
		req.getSession().setAttribute("product" , product.getProduct_name());
		req.getSession().setAttribute("product_details" , product.getDetails());
		req.getSession().setAttribute("product_username" , product.getSeller().getFull_name());
		return "views/apply_for_bid"; 
	}
	
	@RequestMapping(value = "/bid_action_product", method = RequestMethod.POST)
	public void registerUser(
			
			HttpServletRequest req, 
			HttpServletResponse res,
			@ModelAttribute("applyBid") Auction auction) 
			throws IOException {
		
		auction.setBuyer(targetted_buyer);
		auction.setSeller(targetted_seller);
		auction.setProduct(targetted_product);
		auction.setStatus("Active");
		
		Date date = new Date();
		System.out.println(date);
		auction.setDate(date);
		auctionService.persist(auction);
		res.sendRedirect("dashboard_user");
	}
}