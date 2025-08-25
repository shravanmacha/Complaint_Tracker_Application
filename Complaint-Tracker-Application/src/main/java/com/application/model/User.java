package com.application.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	private String name;
	
	private String email;
	
	private String password;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "user_complaints", 
		joinColumns = {@JoinColumn(name = "userId")},
		inverseJoinColumns = {@JoinColumn(name = "complaintId")}
	)
	private List<Complaint> complaints = new ArrayList<Complaint>();
	
	public User() {
		
	}
	
	public User(int userId, String name, String email, String password, List<Complaint> complaint) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.complaints = complaint;
	}

	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public void removeComplaint(Complaint complaint) {
	    complaints.remove(complaint);
	    complaint.getUsers().remove(this);
	}
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Complaint> getComplaint() {
		return complaints;
	}

	public void setComplaint(List<Complaint> complaints) {
		this.complaints = complaints;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", complaint=" + complaints + "]";
	}
	
	
}
