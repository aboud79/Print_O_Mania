package com.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.User;
import com.controller.DBConn;

public class UserDaoImpl implements UserDao {
	private Connection conn;
	
	public UserDaoImpl(){
		conn= DBConn.getConnection();
	}
	
	public void addUser(User user){
		try{
			PreparedStatement preparedStmt= conn.prepareStatement("insert into users(fname, lname, emailId, userId, password, role) values (?,?,?,?,?,?)");
			preparedStmt.setString(1, user.getFname());
			preparedStmt.setString(2, user.getLname()); 
			preparedStmt.setString(3, user.getEmailId());
			preparedStmt.setString(4, user.getUserId());
			preparedStmt.setString(5, user.getPassword());
			preparedStmt.setString(6, user.getRole());
			preparedStmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void delete(User user){
		try{
			PreparedStatement preparedStmt= conn.prepareStatement("delete from users where userId='"+user.getUserId()+"'");
			preparedStmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public boolean checkUserIdExist(String userId) {

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement("select * from users where userId='"+userId+"'");
		
			ResultSet rs= preparedStatement.executeQuery();
			while(rs.next()){
				return true;
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	
	}
	public boolean authenticateUsers(String userId, String password){
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement("select * from users where userId='"+userId+"' and password='"+password+"'");
		
			ResultSet rs= preparedStatement.executeQuery();
			while(rs.next()){
				return true;
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public List<User> getUserNameById(String userId) {
		PreparedStatement preparedStatement;
		String userName= null;
		String role= null;
		List<User> user= new ArrayList<User>();

		try {
			preparedStatement = conn.prepareStatement("select * from users where userId='"+userId+"'");
		
			ResultSet rs= preparedStatement.executeQuery();
			while(rs.next()){
				userName = rs.getString("fname");
				role= rs.getString("role");
				User u = new User();
				u.setFname(rs.getString("fname"));
				u.setRole(rs.getString("role"));
				user.add(u);
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	   public void updateUser(User user) {
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement("update users set fname=?, lname=?, emailId=?, userId=?, password=?, address=?, phoneNo=? where userid=?");
	            preparedStatement.setString(1, user.getFname());
	            preparedStatement.setString(2, user.getLname());
	            preparedStatement.setString(3, user.getEmailId());
	            preparedStatement.setString(4, user.getUserId());
	            preparedStatement.setString(5, user.getPassword());
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	   
	  
}
