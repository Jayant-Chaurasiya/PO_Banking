package com.revature.project1.service;

import com.revature.project1.dao.*;
import com.revature.project1.model.Customer;
import com.revature.project1.model.User;

public class UserServiceImpl implements UserService {

	UserDAO userDAO=new UserDAOImpl();
	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int addUser(User user) {
		int userId= userDAO.addUser(user);
		return userId;
	}

	public User getUserById(int userId) {
		return userDAO.getUserById(userId);
	}

	public boolean isUserExists(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean validateUser(int userId, String userPassword) {
		return userDAO.validateUser(userId, userPassword);
	}



}
