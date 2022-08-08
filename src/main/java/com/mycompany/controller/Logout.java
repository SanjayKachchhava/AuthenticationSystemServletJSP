package com.mycompany.controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Logout extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("email");
		
		response.sendRedirect("login");
	}
}
