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
 * Servlet implementation class ProductPageController
 */
@WebServlet("/ProductPageController")
public class ProductPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productID=request.getParameter("id");
		PageService page=new PageServiceImpl();
		try {
			List<Product> viewProduct=page.viewProduct(productID);
			List<byte[]> imageData=new ArrayList<byte[]>();
			HttpSession hs1=request.getSession();
			hs1.setAttribute("viewProduct", viewProduct);
			for(Product p:viewProduct){
				imageData.add(p.getImage().getBytes(1,(int) p.getImage().length()));
			}
			hs1.setAttribute("image", imageData);
			request.getRequestDispatcher("viewProduct.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId=(String) session.getAttribute("userId");
		System.out.print("imageid---------"+ userId);
		String productId=request.getParameter("productId");
		System.out.print("productId---------"+ productId);
		PageService page=new PageServiceImpl();
		page.addCartProduct(userId, productId);
		session.setAttribute("addedToCart", "Product successfully added to cart");
		response.sendRedirect("viewProduct.jsp");
		
	}

}
