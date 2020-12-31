package com.eauction.controller;

import java.io.IOException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class AddProductController {

	public AddProductController() {
		
	}

	@RequestMapping( "/add_product")
	public String getaddProduct()
	{	
		
		return "views/add_product"; 
	}

	@RequestMapping(value = "/add_product_user", method = RequestMethod.POST)
	public void addProduct(
			@RequestParam("add_username") String addUsername,
			@RequestParam("add_product") String addProduct,
			@RequestParam("add_details") String addDetails,
			@RequestParam("add_minimum_bid") int addMinBid,
			@RequestParam("add_opening_date") String addOpenDate,
			@RequestParam("add_closing_date")  String addCloseDate,
			@RequestParam("add_email") String addEmail,
			@RequestParam("add_mobile") String addMobile,
			@RequestParam("img") MultipartFile file,HttpServletResponse res) 
			throws IOException {
		
		
		System.out.println(file.getOriginalFilename());
				res.sendRedirect("view_product") ;
		
		
	}

}
