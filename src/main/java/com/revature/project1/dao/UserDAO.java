package com.revature.project1.dao;

import com.revature.project1.model.Customer;
import com.revature.project1.model.User;

public interface UserDAO {
	
	public int addCustomer(Customer customer);
	
	public int addUser(User user);
	
	public User getUserById(int userId);
	
	public boolean isUserExists(int userId);
	
	public boolean validateUser(int userId, String userPassword);

}
