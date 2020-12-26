package com.eauction.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

		public UserController() {
		
		}
	
		@RequestMapping( "/user")
		public String getLoginForm()
		{	
			
			return "views/login-user"; 
		}

		@RequestMapping(value = "/login_action_user", method = RequestMethod.POST)
		public void checkCreds(
				@RequestParam("username_user") String usernm,
				@RequestParam("password_user") String passwd,
				HttpServletRequest req, 
				HttpServletResponse res) 
				throws IOException {
			
			if(usernm.equals("user") && passwd.equals("#user"))
			{
				req.getSession().setAttribute("username_user", usernm);
				System.out.println(usernm);
				
				try {
					res.sendRedirect("dashboard_user");
				}catch(Exception e) {
					System.out.println(e);
				}
				
			}
			else
			{
				res.sendRedirect("user");
			}
			
		}
		
		@RequestMapping("/logout_user")
		public void logoutAdminUser(HttpServletRequest req,HttpServletResponse res) throws IOException
		{
			req.getSession().invalidate();
			
			res.sendRedirect("user");
		}
		
		@RequestMapping( "/new_register")
		public String getRegisterForm()
		{	
			
			return "views/register-user"; 
		}
		
		@RequestMapping(value = "/register_action_user", method = RequestMethod.POST)
		public void registerUser(
				@RequestParam("firstname") String firstname,
				@RequestParam("lastname") String lastname,
				@RequestParam("email") String email,
				@RequestParam("address") String address,
				@RequestParam("dob") String dob,
				@RequestParam("password") String password,
				@RequestParam("confirm_password") String confirm_password,
				HttpServletRequest req, 
				HttpServletResponse res) 
				throws IOException {
			
			if(password.equals(confirm_password))
			{
				System.out.println(firstname);
				
				try {
					res.sendRedirect("user");
				}catch(Exception e) {
					System.out.println(e);
				}
				
			}
			else
			{
				   System.out.println("<script type=\"text/javascript\">");
				   System.out.println("alert('User or password incorrect');");
				   System.out.println("location='index.jsp';");
				   System.out.println("</script>");
				res.sendRedirect("new_register") ;
			}
			
		}

	}
	

