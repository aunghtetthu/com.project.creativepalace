package com.creativepalace.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.db.StudentDB;
import com.creativepalace.model.Student;

@WebServlet("/user/login")
public class Login extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("studentObj") != null) {
			response.sendRedirect("index");
		} else {
//			if(session.isNew()) {
//				session.setAttribute("error", false);
//				session.setAttribute("errorMessage", "");
//			}
			
			if (session.getAttribute("error") == null) {
				session.setAttribute("error", false);
				session.setAttribute("errorMessage", "");
			}
			
			try {
				this.addViewObject("error", session.getAttribute("error"));
				this.addViewObject("errorMessage", session.getAttribute("errorMessage"));
				this.setHeader("studentPlainHeader");
				this.showView(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean error;
		String errorMessage;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);
		
		StudentDB sdb = new StudentDB();
		Student s = sdb.getStudentByEmail(email);
		
		if(s.getStudentEmail() != null) {
			if(password.equals(s.getStudentPassword())) {
				session.setAttribute("studentObj", s);
				error = false;
				errorMessage = "";
			} else {
				error = true;
				errorMessage = "Password is incorrect.";
			}
		} else {
			error = true;
			errorMessage = "Email is incorret.";
		}
		
		session.setAttribute("error", error);
		session.setAttribute("errorMessage", errorMessage);
		doGet(request, response);
	}

}
