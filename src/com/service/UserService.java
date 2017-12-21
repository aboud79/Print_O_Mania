package com.service;

import java.util.List;

import com.model.User;

public interface UserService {

	boolean checkUserIdExist(String userId);

	void addUser(User user);

	List<User> getUserNameById(String userId);

	boolean authenticateUsers(String userId, String password);

}
