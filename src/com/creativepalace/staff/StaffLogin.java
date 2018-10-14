package com.creativepalace.staff;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.db.StaffDB;
import com.creativepalace.model.Staff;

@WebServlet("/custom/staff_login")
public class StaffLogin extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("staffObj") != null) {
			response.sendRedirect("staff_home");
		} else {
			if (session.getAttribute("error") == null) {
				session.setAttribute("error", false);
				session.setAttribute("errorMessage", "");
			}

			try {
				this.addViewObject("error", session.getAttribute("error"));
				this.addViewObject("errorMessage", session.getAttribute("errorMessage"));
				this.setHeader("staffPlainHeader");
				this.showView(request, response);
			} catch (Exception e) {
				// TODO: handle exception
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
		
		StaffDB sdb = new StaffDB();
		Staff s = sdb.getStaffByEmail(email);
		
		if(s.getStaffEmail() != null) {
			if(password.equals(s.getStaffPassword())) {
				session.setAttribute("staffObj", s);
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
