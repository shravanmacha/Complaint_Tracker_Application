package com.application.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.application.dao.UserDao;
import com.application.model.User;

@WebServlet("/UserSignUpServlet")
public class UserSignUpServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm-password");
		
		User user = new User(name, email, password);
		UserDao userDao = new UserDao();
		userDao.insertUser(user);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("userLogin.jsp");
		requestDispatcher.forward(request, response);
	}

}
