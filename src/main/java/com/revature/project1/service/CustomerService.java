package com.revature.project1.service;

import java.util.List;

import com.revature.project1.model.Customer;

public interface CustomerService {
	public int addCustomer(Customer customer);
	public boolean deleteCustomer(int customerId);
	public boolean updateCustomer(Customer customer);
	public Customer getCustomerById(int customerId);
	public List<Customer> getCustomers();
	public boolean isCustomerExists(int customerId);
	
	//* As a customer, I can view the balance of a specific account. * 
	public int viewBalance(int customerId);
	
	//As a customer, I can make a withdrawal or deposit to a specific/my account. 
	public int deposit(int customerId,int amount);
	public boolean withdraw(int customerId,int amount);
	//			1019		1918		6000
	public boolean transferAmount(int customerId, int amount, int receiverId);
	public boolean validateCustomer(int customerId,String customerPassword);
	public Customer getCustomerName(int customerId,String customerPassword);
	public String getCustomerStatus(int customerId);

}
