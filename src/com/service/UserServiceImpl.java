package com.service;

import java.util.List;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.model.User;

public class UserServiceImpl implements UserService {
	 UserDao userDao = new UserDaoImpl(); 

	public boolean checkUserIdExist(String userId) {
		boolean users= userDao.checkUserIdExist(userId);		
        return users;
	}
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}
	public boolean authenticateUsers(String userId, String password) {
		boolean users= userDao.authenticateUsers(userId,password);		
        return users;
	}
	public List<User> getUserNameById(String userId) {
		List<User> user = userDao.getUserNameById(userId); 	
		return user;
	}
}
