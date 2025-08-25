package com.application.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.application.dao.AdminDao;
import com.application.model.Admin;

@WebServlet("/AdminSignUpServlet")
public class AdminSignUpServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm-password");
		
		Admin admin = new Admin(name, email, password);
		AdminDao adminDao = new AdminDao();
		adminDao.insertAdmin(admin);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("adminLogin.jsp");
		requestDispatcher.forward(request, response);
	}

}
