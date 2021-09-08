package com.revature.project1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
      
import com.revature.project1.model.Customer;
import com.revature.project1.util.HibernateUtil;

public class CustomerDAOImpl implements CustomerDAO {
	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	Session session=sessionFactory.openSession();
	

	public int addCustomer(Customer customer) {
		Transaction transaction=session.beginTransaction();
		session.save(customer);
		transaction.commit();
		int customerId=customer.getCustomerId();
		return customerId;
		
	}

	public boolean deleteCustomer(int customerId) {
		Transaction transaction=session.beginTransaction();
		Customer customer=new Customer();
		customer.setCustomerId(customerId);
		session.delete(customer);;
		transaction.commit();
		return true;
		
	}

	public boolean updateCustomer(Customer customer) {
		Transaction transaction=session.beginTransaction();
		session.update(customer);
		transaction.commit();
		return true;
	}

	public Customer getCustomerById(int customerId) {
		Customer customer=session.load(Customer.class, customerId);
		return customer;
	}

	public List<Customer> getCustomers() {
		Query<Customer> query=session.createQuery("from com.revature.project1.model.Customer");
		List<Customer> customers=query.list();
		return customers;
	}

	public boolean isCustomerExists(int customerId) {
		Customer customer =session.get(Customer.class, customerId);
		if(customer==null) 
			return false;
		else
			return true;
	}

	public int viewBalance(int customerId) {
		Query query=session.createQuery("select customerBalance from com.revature.project1.model.Customer where customerId= "+customerId);
		int balance= (Integer) query.list().get(0);
		
		return balance;
		}

	public int deposit(int customerId,  int amount) {
		Transaction transaction=session.beginTransaction();
		Query query=(Query)session.getNamedQuery("deposit")
				.setParameter("amount", amount)
		.setParameter("customerId", customerId);
		query.executeUpdate();
		transaction.commit();
				
		
		return amount;
		}

	public boolean withdraw(int customerId,int amount) {
		Transaction transaction=session.beginTransaction();
		Query query=(Query)session.getNamedQuery("withdraw")
				.setParameter("amount", amount)
				.setParameter("customerId", customerId);
		query.executeUpdate();
		transaction.commit();
				
		
		return true;
	}

	public boolean transferAmount(int customerId, int amount, int receiverId) {
		Transaction transaction=session.beginTransaction();
		Query query=(Query)session.getNamedQuery("withdraw")
				.setParameter("amount", amount)
				.setParameter("customerId", customerId);
		query.executeUpdate();
		transaction.commit();
		transaction=session.beginTransaction();
		query=(Query)session.getNamedQuery("deposit")
				.setParameter("amount", amount)
				.setParameter("customerId", receiverId);
		query.executeUpdate();
		transaction.commit();
		
		return true;
	}

	public boolean validateCustomer(int customerId, String customerPassword) {
		Query query=session.createQuery("from com.revature.project1.model.Customer where customerId="+customerId + "and customerPassword='"+customerPassword+"'");
		if(query.list().size()==0) {
			return false;
		}
		else {
			return true;
		}
	}

	public Customer getCustomerName(int customerId, String customerPassword) {
		Query<Customer> query=session.createQuery("from com.revature.project1.model.Customer where customerId= "+customerId+" and customerPassword='"+customerPassword+"'");
		List<Customer> customers=query.list();
		Customer customer=customers.get(0);
		return customer;
	}

	public String getCustomerStatus(int customerId) {
		Query query=session.createQuery("select customerStatus from com.revature.project1.model.Customer where customerId= "+customerId);
		String status= (String) query.list().get(0);
		
		return status;
	}

	

}
