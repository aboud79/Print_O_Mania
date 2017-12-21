package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.controller.DBConn;
import com.model.User;

public class AdminUserDaoImpl implements AdminUserDao {
	Connection conn;
	public AdminUserDaoImpl()
	{
		conn= DBConn.getConnection();
	}
	
	public List viewuserdata() {
		List ls= new ArrayList();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement("select * from users ");
		
			ResultSet rs= preparedStatement.executeQuery();
			while(rs.next()){
				User data= new User();
				data.setEmailId(rs.getString("emailId"));
				data.setFname(rs.getString("fname"));
				data.setLname(rs.getString("lname"));
				data.setUserId(rs.getString("userId"));
				data.setGender(rs.getString("gender"));
				ls.add(data);
			}
		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}
}
