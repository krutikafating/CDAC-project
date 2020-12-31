package com.eauction.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class userDBController {

	@RequestMapping("/dashboard_user")
	public String loadDashboard(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		
		String username = (String)req.getSession().getAttribute("username_user");
		
		if(username == null) {
			res.sendRedirect("login-user");
			
		}
		return "views/dashboard_user";
	}
	

	
	
	
	
	
	
}
