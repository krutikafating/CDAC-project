package com.eauction.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eauction.dao.UserDAO;
import com.eauction.db.HibernateDatabaseConnection;
import com.eauction.model.User;
import com.eauction.service.UserService;
import com.eauction.util.Alerts;

@Controller
public class UserController {

	UserService userService = new UserService();
    
		public UserController() {
		
		}
	
		@RequestMapping( "/user")
		public String getLoginForm(HttpServletRequest req,HttpServletResponse res,
				Model m)
		{	
			String message_from_req = (String)req.getSession().getAttribute("message");
			 m.addAttribute("message", message_from_req);
			 HttpSession session = req.getSession();
			 session.setAttribute("message", null);
			 
			 User user = (User)req.getSession().getAttribute("user_object");
			 
			 if(user == null) {
				 return "views/login-user"; 
			 }else {
				 
				 return "redirect:dashboard_user";
			 }
					
		}

		
		@RequestMapping(value = "/login_action_user", method = RequestMethod.POST)
		public void checkCreds(
				@RequestParam("email") String email,
				@RequestParam("password") String passwd,
				HttpServletRequest req, 
				HttpServletResponse res,Model m,
				RedirectAttributes redirectAttributes) 
				throws IOException {
			
			
			
			List<User> users = 	userService.findByEmail(email);
			if(users.size() < 1) {
				System.out.println("user not found");
				req.getSession().setAttribute("message", "User not found!");
					res.sendRedirect("user");
				
			}else {
				System.out.println(users.get(0).getPassword());
//				m.addAttribute("users_list",users);
				if(passwd.equals(users.get(0).getPassword()))
				{
					req.getSession().setAttribute("user_object", users.get(0));
					req.getSession().setAttribute("full_name",users.get(0).getFull_name() );
					
					try {
						System.out.println("dashboard_user");
						res.sendRedirect("dashboard_user");
					}catch(Exception e) {
						System.out.println(e);
					}
					
				}
				else
				{
					req.getSession().setAttribute("message", "Password Incorrect");
					res.sendRedirect("user");
				}
			}
			
		}
		

		//User logout action
		
		@RequestMapping("/logoutUser")
		public String logoutUser(HttpServletRequest req,HttpServletResponse res) throws IOException
		{
			req.getSession().invalidate();
			
			//res.sendRedirect("user");
			return "views/auctionheader";
		}
		
		
		//User New Registration action
		
		
		@RequestMapping( "/new_register")
		public String getRegisterForm(HttpServletRequest req, Model m)
		{	
			
			m.addAttribute("register_new",new User());
			
			String message_from_req = (String)req.getSession().getAttribute("message");
			 m.addAttribute("message", message_from_req);
			 req.getSession().setAttribute("message", null);
			return "views/register-user"; 
		}
		
		@RequestMapping(value = "/register_action_user", method = RequestMethod.POST)
		public String registerUser(
		HttpServletRequest req, 
		HttpServletResponse res,
				@Valid @ModelAttribute("register_new") User user1 , BindingResult result) 
				throws IOException {
			
			//List<User> users = 	userService.findByEmail(user1.getEmail());
			
			
			if(result.hasErrors()) {
				System.out.println("my form has errors..");
				return "views/register-user";
			}
			else {
				
				if(user1.getPassword().equals(user1.getConfirm_password()))
					{
						
						userService.persist(user1);
			
					try {
						req.getSession().setAttribute("message", "Registration successful. Please login with your credentials.");  
						return "redirect:user";
						}catch(Exception e) {
							System.out.println(e);
							return "redirect:new_register";
						}
			
					}
				else
					{
						req.getSession().setAttribute("message", "Passwords must be same.");  
						return "redirect:new_register";
					}
				
			
				}
		}
//				if(user1.getPassword().equals(user1.getConfirm_password()))
//				{
//					
//					userService.persist(user1);
//		
//				try {
//					req.getSession().setAttribute("message", "Registration successful. Please login with your credentials.");  
//					res.sendRedirect("user");
//					}catch(Exception e) {
//						System.out.println(e);
//					}
//				
//			}
//			else
//			{
//				req.getSession().setAttribute("message", "Passwords must be same.");  
//				res.sendRedirect("new_register") ;
//			}
		
		}
		
	
	

