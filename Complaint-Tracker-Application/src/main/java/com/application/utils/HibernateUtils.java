package com.application.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.application.model.Admin;
import com.application.model.Complaint;
import com.application.model.User;

public class HibernateUtils {
	
	public static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			Configuration cfg = new Configuration();
			cfg.configure();
			cfg.addAnnotatedClass(User.class);
			cfg.addAnnotatedClass(Complaint.class);
			cfg.addAnnotatedClasses(Admin.class);
			
			sessionFactory = cfg.buildSessionFactory();
			return sessionFactory;
		}
		return sessionFactory;
	}
}
