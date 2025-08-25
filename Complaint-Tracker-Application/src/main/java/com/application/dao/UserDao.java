package com.application.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.application.model.User;
import com.application.utils.HibernateUtils;

public class UserDao {
    public void insertUser(User user) {
    	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    	Session session = sessionFactory.openSession();
    	
    	session.beginTransaction();
    	session.persist(user);
    	session.getTransaction().commit();
    }
    
    public User validateUser(String email, String password) {

        Session session = HibernateUtils.getSessionFactory().openSession(); 
            // HQL query
            String hql = "FROM User U WHERE U.email = :email AND U.password = :password";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("email", email);
            query.setParameter("password", password);
        
        return query.uniqueResult();  // true if user exists
    }
    
    public void updateUser(User user) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(user);   // merge will update user + join table
            session.getTransaction().commit();
        }
    }
    
}
