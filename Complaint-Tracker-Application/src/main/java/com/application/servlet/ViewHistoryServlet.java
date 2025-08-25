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

@WebServlet("/ViewHistoryServlet")
public class ViewHistoryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("loggedUser");
		
		if(user != null) {
			ComplaintDao complaintDao = new ComplaintDao();
			List<Complaint> solvedComplaints = complaintDao.viewHistory(user);
			request.setAttribute("solvedComplaints", solvedComplaints);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewHistory.jsp");
			requestDispatcher.forward(request, response);
		}else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("complaints.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
