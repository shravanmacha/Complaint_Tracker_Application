package com.application.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "complaints")
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int complaintId;
	
	private String name;
	
	private String flatNo;
	
	private String date; 
	
	private String phoneNumber;
	
	private String status;
	
	@ManyToMany(mappedBy = "complaints", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<User> users = new ArrayList<User>();
	
	public Complaint() {
		
	}

	public Complaint(int complaintId, String name, String flatNo, String date, String phoneNumber, String status) {
		super();
		this.complaintId = complaintId;
		this.name = name;
		this.flatNo = flatNo;
		this.date = date;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	public Complaint( String name, String date, String phoneNumber, List<User> users) {
		super();
		this.name = name;
		this.date = date;
		this.phoneNumber = phoneNumber;
		this.users = users;
	}
	

	public Complaint(String name, String date, String phoneNumber) {
		super();
		this.name = name;
		this.date = date;
		this.phoneNumber = phoneNumber;
	}

	public Complaint(String name, String flatNo, String date, String phoneNumber, String status) {
		super();
		this.name = name;
		this.flatNo = flatNo;
		this.date = date;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", name=" + name + ", flatNo=" + flatNo + ", date=" + date
				+ ", phoneNumber=" + phoneNumber + ", status=" + status + ", users=" + users + "]";
	}
	
}
