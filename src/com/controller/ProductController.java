package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Product;
import com.service.PageService;
import com.service.PageServiceImpl;

/**
 * Servlet implementation class productController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageService page=new PageServiceImpl();
		try {
			List<Product> recentProducts=page.getRecentProducts();
			List<byte[]> imageData=new ArrayList<byte[]>();
			HttpSession hs=request.getSession();
			hs.setAttribute("productList", recentProducts);
			for(Product p:recentProducts){
				imageData.add(p.getImage().getBytes(1,(int) p.getImage().length()));
			}
			hs.setAttribute("imageData", imageData);
			request.getRequestDispatcher("homePage.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
	}
		// TODO Auto-generated method stub
	}


