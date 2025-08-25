package com.application.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.application.model.Admin;
import com.application.model.User;
import com.application.utils.HibernateUtils;

public class AdminDao {
	public void insertAdmin(Admin admin) {
    	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    	Session session = sessionFactory.openSession();
    	
    	session.beginTransaction();
    	session.persist(admin);
    	session.getTransaction().commit();
    }
	
	public Admin validateUser(String email, String password) {

        Session session = HibernateUtils.getSessionFactory().openSession(); 
            // HQL query
            String hql = "FROM Admin A WHERE A.adminEmail = :adminEmail AND A.password = :password";
            Query<Admin> query = session.createQuery(hql, Admin.class);
            query.setParameter("adminEmail", email);
            query.setParameter("password", password);
        
        return query.uniqueResult();  // true if user exists
    }
}
