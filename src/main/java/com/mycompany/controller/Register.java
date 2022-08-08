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

public class Register extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("register.html");
		rd.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("pswd");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		PrintWriter out = response.getWriter();
		
		
		if(Auth.register(email, password,firstname,lastname)) {
			out.println("registered successfully");
			response.sendRedirect("login");
		}else {
			out.println("something went wrong!!");
		}
	}
}
