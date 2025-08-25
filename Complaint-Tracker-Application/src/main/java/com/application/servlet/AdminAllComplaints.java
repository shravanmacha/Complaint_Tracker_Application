package com.application.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.application.dao.ComplaintDao;
import com.application.model.Complaint;

@WebServlet("/AdminAllComplaints")
public class AdminAllComplaints extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComplaintDao complaintDao = new ComplaintDao();
		List<Complaint> complaints = complaintDao.getAllComplaints();
		request.setAttribute("complaints", complaints);
        request.getRequestDispatcher("allComplaints.jsp").forward(request, response);
	}

}
