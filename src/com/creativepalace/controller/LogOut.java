package com.creativepalace.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/custom/logout")
public class LogOut extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String redirectPage;
		
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("staffObj") != null) {
			redirectPage = "staff_login";
		} else {
			redirectPage = "student_login";
		}
		session.invalidate();
		response.sendRedirect(redirectPage);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
}
