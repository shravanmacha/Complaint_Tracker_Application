package com.application.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.application.dao.ComplaintDao;

@WebServlet("/UpdateComplaintStatusServlet")
public class UpdateComplaintStatusServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("status");
		int complaintId = 0;
		String idParam = request.getParameter("complaintId");
		if (idParam != null && !idParam.isEmpty()) {
		    complaintId = Integer.parseInt(idParam);
		    // proceed
		} else {
		    throw new IllegalArgumentException("Complaint ID is missing!");
		}
		ComplaintDao complaintDao = new ComplaintDao();
		complaintDao.updateComplaintStatus(complaintId, status);
		
		response.sendRedirect("AdminAllComplaints");
		
	}

}
