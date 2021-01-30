package com.eauction.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eauction.dao.ProductDAO;
import com.eauction.db.HibernateDatabaseConnection;
import com.eauction.model.Product;
import com.eauction.model.User;
import com.eauction.service.ProductService;
import com.eauction.service.UserService;

@Controller
public class ViewProController {
	
	ProductService productService = new ProductService();
	
	
	
	@RequestMapping( "/view_product")
	public String getviewProduct(HttpServletRequest req, Model m)
	{	
		// getting the user id to get only the products which are uploaded by that user
		
		int seller_id = ((User)req.getSession().getAttribute("user_object")).getId();
		List<Product> products = 	productService.findAllProductsdBySellerId(seller_id);


		m.addAttribute("product_list",products);
		
		System.out.println(products);
		return "views/view_product"; 
	}
	
	@RequestMapping(value = "/getImage/{id}")
	public void getPhoto(HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		System.out.println("The id is : " + id);
		Product item = productService.findById(id);
		System.out.println(item.getImage());
		response.getOutputStream().write(item.getImage());
		System.out.println("item");
		response.getOutputStream().close();
}
	
}
