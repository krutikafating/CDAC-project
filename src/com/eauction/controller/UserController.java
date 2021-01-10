package com.eauction.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eauction.dao.UserDAO;
import com.eauction.db.HibernateDatabaseConnection;
import com.eauction.model.User;
import com.eauction.service.UserService;

@Controller
public class UserController {

	UserService userService = new UserService();
    
		public UserController() {
		
		}
	
		@RequestMapping( "/user")
		public String getLoginForm()
		{	
			
			
//			Session session = null;
//			session = HibernateDatabaseConnection.getSessionFactory().openSession();
//			Query query2 = session.createQuery("FROM User");
//			List users = query2.list();
//
//			System.out.println(users);
//			m.addAttribute("users_list",users);
//			
			
			
			return "views/login-user"; 
			
			
			
			
		}

		
		@RequestMapping(value = "/login_action_user", method = RequestMethod.POST)
		public void checkCreds(
				@RequestParam("email") String email,
				@RequestParam("password") String passwd,
				HttpServletRequest req, 
				HttpServletResponse res,Model m) 
				throws IOException {
			
//			Session session = null;
//			session = HibernateDatabaseConnection.getSessionFactory().openSession();
//			Query query2 = session.createQuery(String.format("FROM User where email='%s'", email));
//			List<User> users = query2.list();
			
			
			List<User> users = 	userService.findByEmail(email);
			if(users.size() < 1) {
				System.out.println("user not found");
					res.sendRedirect("user");
				
			}else {
				System.out.println(users.get(0).getPassword());
//				m.addAttribute("users_list",users);
				if(passwd.equals(users.get(0).getPassword()))
				{
					req.getSession().setAttribute("username_user", email);
					req.getSession().setAttribute("first_name",users.get(0).getFirst_name() );
					
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
		
			
			
		}
		
//		
//		public void checkCreds(
//				@RequestParam("email") String usernm,
//				@RequestParam("password") String passwd,
//				HttpServletRequest req, 
//				HttpServletResponse res) 
//				throws IOException {
//			
//			if(usernm.equals("user") && passwd.equals("#user"))
//			{
//				req.getSession().setAttribute("username_user", usernm);
//				
////				
//				try {
//					res.sendRedirect("dashboard_user");
//				}catch(Exception e) {
//					System.out.println(e);
//				}
//				
//			}
//			else
//			{
//				res.sendRedirect("user");
//			}
			
		
		
		
		
		
		
		//User logout action
		
		@RequestMapping("/logoutUser")
		public void logoutUser(HttpServletRequest req,HttpServletResponse res) throws IOException
		{
			req.getSession().invalidate();
			
			res.sendRedirect("user");
		}
		
		
		
		
		
		
		
		
		//User New Registration action
		
		
		@RequestMapping( "/new_register")
		public String getRegisterForm()
		{	
			
			return "views/register-user"; 
		}
		
		@RequestMapping(value = "/register_action_user", method = RequestMethod.POST)
		public void registerUser(
				HttpServletRequest req, 
				HttpServletResponse res,
				@ModelAttribute("register_new") User user1) 
				throws IOException {
			
				if(user1.getPassword().equals(user1.getConfirm_password()))
				{
					
					userService.persist(user1);
		
//					Session session = null;
//					session = HibernateDatabaseConnection.getSessionFactory().openSession();
//					
//					Transaction t = session.beginTransaction();
//					
//					session.save(user1);
//					t.commit();
				try {
					res.sendRedirect("user");
					}catch(Exception e) {
						System.out.println(e);
					}
				
			}
			else
			{
				  
				res.sendRedirect("new_register") ;
			}
		
				
			
			
			
		}
		
		
		
		
		//Add Auction action
		
		@RequestMapping( "/add_auctions")
		public String getauctionProduct()
		{	
			
			return "views/auction"; 
		}
		

	}
	

