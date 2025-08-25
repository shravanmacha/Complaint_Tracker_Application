package com.application.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.application.dao.ComplaintDao;
import com.application.model.Complaint;
import com.application.model.User;

@WebServlet("/ViewComplaintsServlet")
public class ViewComplaintsServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    doPost(request, response); // Forward GET to POST
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("loggedUser");
		
		if(user != null) {
			ComplaintDao complaintDao = new ComplaintDao();
			List<Complaint> complaints = complaintDao.viewComplaints(user);
			request.setAttribute("complaints", complaints);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewComplaints.jsp");
			requestDispatcher.forward(request, response);
		}else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("userLogin.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
