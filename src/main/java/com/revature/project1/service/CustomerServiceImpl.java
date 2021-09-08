package com.revature.project1.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.revature.project1.dao.*;
import com.revature.project1.model.Customer;
import com.revature.project1.util.HibernateUtil;

public class CustomerServiceImpl implements CustomerService {

	CustomerDAO customerDAO=new CustomerDAOImpl();

	public int addCustomer(Customer customer) {
		int customerId= customerDAO.addCustomer(customer);
		return customerId;
	}

	public boolean deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return false;
		
	}

	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	public Customer getCustomerById(int customerId) {
		return customerDAO.getCustomerById(customerId);
	}

	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}

	public boolean isCustomerExists(int customerId) {
		return customerDAO.isCustomerExists(customerId);
	}

	public int viewBalance(int customerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deposit(int customerId,int amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean withdraw(int customerId,int amount) {
		int balance=customerDAO.viewBalance(customerId);
		if(amount>balance) {
			return false;
		}
		else {
			return customerDAO.withdraw(customerId,amount);
			
		}
		
	}

	public boolean transferAmount(int customerId, int amount, int receiverId) {
		int balance=customerDAO.viewBalance(customerId);
		if(amount>balance) {
			return false;
		}
		else {
			return customerDAO.transferAmount(customerId, amount, receiverId);
			
		}
	}

	public boolean validateCustomer(int customerId, String customerPassword) {
		return customerDAO.validateCustomer(customerId, customerPassword);
	}

	public Customer getCustomerName(int customerId, String customerPassword) {
		return customerDAO.getCustomerName(customerId, customerPassword);
	}

	public String getCustomerStatus(int customerId) {
		if(customerDAO.isCustomerExists(customerId)) {
			return customerDAO.getCustomerStatus(customerId);
		}else {
			return null;
		}
	}

}
