package com.eauction.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

	@RequestMapping("/dashboard")
	public String loadDashboard(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		
		String username = (String)req.getSession().getAttribute("username");
		
		if(username == null) {
			res.sendRedirect("login");
			
		}
		return "views/dashboard";
	}
	
	
	
	
	
}
