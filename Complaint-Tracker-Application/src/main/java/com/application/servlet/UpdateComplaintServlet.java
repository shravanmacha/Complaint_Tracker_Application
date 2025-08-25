package com.application.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.application.dao.ComplaintDao;
import com.application.model.Complaint;

@WebServlet("/UpdateComplaintServlet")
public class UpdateComplaintServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String complaintName = request.getParameter("complaint-name");
		String flatNo = request.getParameter("flatNo");
		String complaintDate = request.getParameter("complaint-date");
		String phoneNumber = request.getParameter("phone-number");
		String status = "raised";
		
		Complaint complaint = new Complaint(id, complaintName, flatNo, complaintDate, phoneNumber, status);
		ComplaintDao complaintDao = new ComplaintDao();
		complaintDao.updateComplaint(complaint);
		
		response.sendRedirect("UpdateDeleteComplaintServlet");
		
	}

}
