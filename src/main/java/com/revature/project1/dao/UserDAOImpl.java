package com.revature.project1.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.project1.model.Customer;
import com.revature.project1.model.User;
import com.revature.project1.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {
	
	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	Session session=sessionFactory.openSession();

	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int addUser(User user) {
		Transaction transaction=session.beginTransaction();
		session.save(user);
		transaction.commit();
		int userId=user.getUserId();
		return userId;
	}

	public User getUserById(int userId) {
		User user=session.load(User.class, userId);
		return user;
	}

	public boolean isUserExists(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean validateUser(int userId, String userPassword) {
		Query query=session.createQuery("from com.revature.project1.model.User where userId="+userId + "and userPassword='"+userPassword+"'");
		if(query.list().size()==0) {
			return false;
		}
		else {
			return true;
		}
	}

	

}
