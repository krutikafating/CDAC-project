package com.eauction.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.eauction.db.HibernateDatabaseConnection;
import com.eauction.model.Product;
import com.eauction.model.User;
import com.eauction.service.ProductService;
import com.eauction.service.UserService;

@Controller
public class AddProductController {

	ProductService productService = new ProductService();
	
	public AddProductController() {
		
	}

	@RequestMapping( "/add_product")
	public String getaddProduct()
	{	
		
		return "views/add_product"; 
	}

	@RequestMapping(value = "/add_product_user", method = RequestMethod.POST)
	public void addProduct(
			HttpServletRequest req,
			HttpServletResponse res,
			@ModelAttribute("product_user") Product product,
			@RequestParam("file") MultipartFile multipartImage) 
			throws IOException {
		

		 
		User seller = ((User)req.getSession().getAttribute("user_object"));
		product.setSeller(seller);
		product.setStatus("Active");
		
		product.setImage(multipartImage.getBytes());
		
		productService.persist(product);
		res.sendRedirect("view_product") ;
		
		
	}

}
