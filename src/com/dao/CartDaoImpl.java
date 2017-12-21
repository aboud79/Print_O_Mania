package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.controller.DBConn;
import com.model.Product;

public class CartDaoImpl implements CartDao {
	private Connection conn;

	public CartDaoImpl(){
		conn= DBConn.getConnection();
	}

	@Override
	public List getProduct(String userId) {		
		PreparedStatement preparedStatement;
	List im,im1=new ArrayList();
	String pid;
	
	try
	{
		System.out.println("");
		System.out.println("SELECT pid FROM cart WHERE userId='"+userId+"'"+"abc"+userId);
			preparedStatement = conn.prepareStatement("SELECT pid FROM cart WHERE userId='"+userId+"'");
			ResultSet rs= preparedStatement.executeQuery();
		//	System.out.println("hello");
			int i=0;
		  while(rs.next())
		  {
		//	  System.out.println(rs.getString("pid"));
			  
			  pid=String.valueOf(rs.getString("pid"));
			  
			  
			  im1.add(pid);
		//	  System.out.println(im1);
		//	  i++;
		  }
	}
	catch (Exception e) 
	{
		// TODO: handle exception
	}
	
	im=createTable(im1);
	return im;
}


	@Override
	public List createTable(List pid) {
		List im=new ArrayList();
	    PageDaoImpl pdi=new PageDaoImpl();
	    List<Product> l=new ArrayList<Product>();
		
		 for(int i=0;i<pid.size();i++)
		 {
			 try {
				String query="SELECT * FROM products WHERE pid='"+pid.get(i)+"'";
				PreparedStatement preparedStmt= conn.prepareStatement(query);
				ResultSet rs = preparedStmt.executeQuery();
				while(rs.next()){
					Product p=new Product();
				//	System.out.print(""+rs.getString("pid"));
					p.setId(rs.getString("pid"));
					p.setName(rs.getString("p_name"));
					p.setCreatedDate(rs.getDate("create_date"));
					p.setPrice(rs.getInt("price"));
					p.setQuantity(rs.getInt("quantity"));
					p.setSize(rs.getString("size"));
					p.setType(rs.getString("p_type"));
					p.setImage(rs.getBlob("p_picture"));
					l.add(p);
				}} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
	
		
		return l;
	}

}
