package com.application.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.application.dao.AdminDao;
import com.application.model.Admin;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		AdminDao adminDao = new AdminDao();
		Admin admin = adminDao.validateUser(email, password);
		
		if(admin != null) {
			HttpSession session = request.getSession();
			 session.setAttribute("loggedAdmin", admin);
			 String name = email.split("@")[0];
			 String formattedName = name.substring(0,1).toUpperCase() + name.substring(1);
			 session.setAttribute("email", formattedName);
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdminAllComplaints");
			 requestDispatcher.forward(request, response);
		 }else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminLogin.jsp");
				requestDispatcher.forward(request, response);
			}
	}

}
