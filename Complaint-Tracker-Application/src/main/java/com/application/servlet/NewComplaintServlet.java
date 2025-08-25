package com.application.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.application.dao.UserDao;
import com.application.model.Complaint;
import com.application.model.User;

@WebServlet("/NewComplaintServlet")
public class NewComplaintServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String complaintName = request.getParameter("complaint-name");
		String flatNo = request.getParameter("flatNo");
		String complaintDate = request.getParameter("complaint-date");
		String phoneNumber = request.getParameter("phone-number");
		String status = "raised";
		
		Complaint complaint = new Complaint(complaintName, flatNo, complaintDate, phoneNumber, status);
		User user = (User) request.getSession().getAttribute("loggedUser");
		
		if(user != null) {
			user.getComplaint().add(complaint);
			complaint.getUsers().add(user);
			
			UserDao userDao = new UserDao();
			userDao.updateUser(user);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("complaints.jsp");
			requestDispatcher.forward(request, response);
		}else {
			response.getWriter().println("User cannot logged in");
		}
		
	}

}
