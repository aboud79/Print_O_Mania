package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;

/**
 * Servlet implementation class RegistrationPage
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 UserService userService= new UserServiceImpl();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	
		String firstName= request.getParameter("fname");
		String lastName= request.getParameter("lname");
		String emailId= request.getParameter("emailId");
		String userId= request.getParameter("userId");
		String password= request.getParameter("passwordsignup");
		String confirmPassword= request.getParameter("passwordsignup_confirm");
		String role= request.getParameter("role");
		String gender = request.getParameter("gender");

		User user = new User();
		user.setEmailId(emailId);
		user.setFname(firstName);
		user.setLname(lastName);
		user.setPassword(password);
		user.setUserId(userId);
		user.setRole(role);
		user.setGender(gender);
		if(user.getFname().isEmpty()||user.getLname().isEmpty()||!user.getUserId().matches("[0-9]+")||!user.getPassword().matches("[a-zA-Z]+") ){
		if(user.getFname().isEmpty()){
			request.setAttribute("Err", "Please enter the First Name");
			
		}
		if(user.getLname().isEmpty()){
			request.setAttribute("Err", "Please enter the Last Name");
			
		}
		if(!user.getUserId().matches("[0-9]+")){
			request.setAttribute("Err", "Enter number");
			
		}
		if(!user.getPassword().matches("[a-zA-Z]+")){
			request.setAttribute("Err", "Enter alphabets");
		
		}
		if(confirmPassword.isEmpty()){
			request.setAttribute("Err", "Re-Enter password");
		
		}
		
		boolean userExist = userService.checkUserIdExist(userId);
		
		if(userExist){
			request.setAttribute("Err", "UserId already exists");
		}
		RequestDispatcher reqdispatcher = request.getRequestDispatcher("LoginRegisterDisplay.jsp");
		reqdispatcher.forward(request, response);
		}
		else{
			userService.addUser(user);
			
			session.setAttribute("userName", user.getFname());
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("UserRegisteredMsg", "User Registered Succesfully");
			RequestDispatcher reqdispatcher = request.getRequestDispatcher("homePage.jsp");
			reqdispatcher.forward(request, response);
		}
	}
}
