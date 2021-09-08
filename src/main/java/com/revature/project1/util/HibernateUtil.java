package com.revature.project1.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	
	public static SessionFactory getSessionFactory() {
		Configuration configuration= new Configuration().configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		return sessionFactory;
	}

}
