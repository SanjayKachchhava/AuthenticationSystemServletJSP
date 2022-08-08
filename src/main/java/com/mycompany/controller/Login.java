package com.mycompany.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.mycompany.dao.Auth;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("pswd");
		
		PrintWriter out = response.getWriter();
		
		
		if(Auth.check(email, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			out.println("login successfully");
			response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("login");
		}
	}

}

