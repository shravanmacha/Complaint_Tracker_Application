package com.application.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.SelectionQuery;

import com.application.model.Complaint;
import com.application.model.User;
import com.application.utils.HibernateUtils;

public class ComplaintDao {
	
	public void insertComplaint(Complaint complaint) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		complaint.setStatus("raised");
		session.persist(complaint);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public List<Complaint> viewComplaints(User user) {
	    List<Complaint> complaints = new ArrayList<>();
	    try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	        SelectionQuery<Complaint> query = session.createSelectionQuery("from Complaint c join c.users u where u.userId = ?1 and (c.status = 'Raised' or c.status = 'pending')", Complaint.class);
	        query.setParameter(1, user.getUserId());
	        complaints = query.getResultList();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return complaints; // ✅ never null
	}
	
	public Complaint updateComplaintbyId(int complaintId) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Complaint complaint = session.find(Complaint.class, complaintId);
		return complaint;	
	}
	
	public void updateComplaint(Complaint complaint) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.merge(complaint);
		session.getTransaction().commit();
	}

	public Complaint deleteComplaint(int complaintId) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		Complaint complaint = session.find(Complaint.class, complaintId);
		if(complaint != null) {
			for(User user : new ArrayList<>(complaint.getUsers())) {
				user.removeComplaint(complaint);
				session.merge(user);
			}
			session.flush();
			session.remove(complaint);
		}
		session.getTransaction().commit();
		return complaint;
	}
	
	public List<Complaint> viewHistory(User user) {
		List<Complaint> complaints = new ArrayList<Complaint>();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query<Complaint> query = session.createQuery(
	            "select c from Complaint c join c.users u where u.userId = ?1 and c.status = 'solved'",
	            Complaint.class
	        );
		query.setParameter(1, user.getUserId());
		complaints = query.getResultList();
		return complaints;
		
	}
	
	public List<Complaint> getAllComplaints() {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		 List<Complaint> complaints = session.createQuery(
			        "FROM Complaint", Complaint.class).list();

		 session.close();
		 return complaints;
	}
	
	public void updateComplaintStatus(int complaintId, String status) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		Complaint complaint = session.find(Complaint.class, complaintId);
		if(complaint != null) {
			complaint.setStatus(status);
			session.merge(complaint);
		}
		session.getTransaction().commit();
		session.close();
	}
}
