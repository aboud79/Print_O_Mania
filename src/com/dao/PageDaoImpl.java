package com.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.controller.DBConn;
import com.model.Product;

public class PageDaoImpl implements PageDao {

		private Connection conn;
		
		public PageDaoImpl(){
			conn= DBConn.getConnection();
		}
		public List<Product> getRecentProducts(){
			List<Product> l=new ArrayList<Product>();
			try {
			String query="SELECT * FROM products";
			PreparedStatement preparedStmt= conn.prepareStatement(query);
			ResultSet rs = preparedStmt.executeQuery();
			while(rs.next()){
				Product p=new Product();
				System.out.print(""+rs.getString("pid"));
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
			return l;
			
		}
		public List<Product> viewProduct(String id){
			List<Product> l=new ArrayList<Product>();
			Product p=new Product();
			try {
			String query="SELECT * FROM products WHERE pid='"+id+"'";
			PreparedStatement preparedStmt= conn.prepareStatement(query);
			ResultSet rs = preparedStmt.executeQuery();
			while(rs.next()){
				System.out.print(""+rs.getString("pid"));
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
			return l;
			
		}
		
		public byte[] getImages(String imageId) throws SQLException {

			   PreparedStatement preparedStatement = conn.prepareStatement("SELECT p_picture FROM `products` WHERE pid='"+imageId+"'");
				ResultSet rs= preparedStatement.executeQuery();

			   byte[] blobAsBytes=new byte[500];
			   while(rs.next()){
			   	Blob blob=rs.getBlob("p_picture");
			   	blobAsBytes=blob.getBytes(1,(int) blob.length());
			   }
			return blobAsBytes;
	}
		@Override
		public void addCartProduct(String userId, String productId) {
			try {
			PreparedStatement preparedStmt= conn.prepareStatement("insert into cart(pid, userId) values (?,?)");
				preparedStmt.setString(1, productId);
				preparedStmt.setString(2, userId);
				preparedStmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

