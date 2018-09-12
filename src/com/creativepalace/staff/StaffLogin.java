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
		boolean errorExistence;
		String errorMessage;

		StaffDB sdb = new StaffDB();
		HttpSession session = request.getSession(true);
		
		if (session.isNew()) {
			errorExistence = false;
			errorMessage = "";
		} else {
			errorExistence = (boolean) session.getAttribute("error");
			errorMessage = (String) session.getAttribute("errorMessage");
		}

		try {
			if (request.getParameter("btnSubmit") != null) {
				String email = request.getParameter("email");
				String password = request.getParameter("password");

				Staff s = sdb.getStaffByEmail(email);
				if (s.getStaffEmail() != null) {
					if (password.equals(s.getStaffPassword())) {
						session.setAttribute("staffObj", s);
						errorExistence = false;
						errorMessage = "";
						String role = s.getStaffRole();
						
						if (role.equals("admin")) {
							response.sendRedirect("admin_home");							
						} else if (role.equals("finance-staff")) {
							response.sendRedirect("finance_home");
						} else if (role.equals("teacher")) {
							response.sendRedirect("teacher_home");
						}
					} else {
						errorExistence = true;
						errorMessage = "Password is incorrect.";
					}
				} else {
					errorExistence = true;
					errorMessage = "Email is incorret.";
				}
			}

			session.setAttribute("error", errorExistence);
			session.setAttribute("errorMessage", errorMessage);
			this.addViewObject("errorExistence", errorExistence);
			this.addViewObject("errorMessage", errorMessage);
			this.setHeader("staffHeader");
			this.showView(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
