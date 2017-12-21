	package com.controller;

	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	import com.dao.CartDao;
	import com.dao.CartDaoImpl;


	/**
	 * Servlet implementation class cartcontroller
	 */
	@WebServlet("/CartController")
	public class CartController extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CartDao c = new CartDaoImpl();
		String user=String.valueOf(session.getAttribute("userId"));
		List list=new ArrayList();
		list=c.getProduct(user);
		
		session.setAttribute("productImage", list);
		response.sendRedirect("viewCart.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//doGet(request, response);
	}

}