package com.eauction.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eauction.db.HibernateDatabaseConnection;

@Controller
public class ViewProController {

	@RequestMapping( "/view_product")
	public String getviewProduct(Model m)
	{	
		
		
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		Query query2 = session.createQuery("FROM Product");
		List products = query2.list();

		m.addAttribute("product_list",products);
		
		
		return "views/view_product"; 
	}
}
