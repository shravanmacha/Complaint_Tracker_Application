package com.application.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.application.dao.UserDao;
import com.application.model.User;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao userDao = new UserDao();
		User user = userDao.validateUser(email, password);
		
		 if(user != null) {
			 HttpSession session = request.getSession();
			 session.setAttribute("loggedUser", user);
			 String name = email.split("@")[0];
			 String formattedName = name.substring(0,1).toUpperCase() + name.substring(1);
			 session.setAttribute("email", formattedName);
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher("complaints.jsp");
			 requestDispatcher.forward(request, response);
		 }else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("userLogin.jsp");
				requestDispatcher.forward(request, response);
			}

}
}
