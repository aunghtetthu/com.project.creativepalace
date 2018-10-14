package com.creativepalace.staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.db.StaffDB;
import com.creativepalace.model.Staff;

@WebServlet("/custom/staff_register")
@MultipartConfig
public class StaffRegister extends AbstractServlet {
	private ControllerUtility cu = new ControllerUtility();
	private final static Logger LOGGER = Logger.getLogger(StaffRegister.class.getCanonicalName());

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("staffObj") != null) {
			response.sendRedirect("staff_home");
		} else {
			if (session.getAttribute("error") == null) {
				session.setAttribute("error", false);
				session.setAttribute("errorMessage", "");
			}
			
			if (request.getParameter("btnSubmit") != null && (boolean) session.getAttribute("error") == false) {
				cu.showAlertMessage(this, true, "Your account has been registered successfully. Please log in.", "staff_login");
			} else {
				cu.showAlertMessage(this, false, "", "");
			}

			try {
				this.addViewObject("error", session.getAttribute("error"));
				this.addViewObject("errorMessage", session.getAttribute("errorMessage"));
				this.setHeader("staffPlainHeader");
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
		HttpSession session = request.getSession(true);

		String password = request.getParameter("password");
		String cPassword = request.getParameter("confirmPassword");
		String email = request.getParameter("email");
		if (password.equals(cPassword)) {
			StaffDB sdb = new StaffDB();
			ArrayList<Staff> result = sdb.retrieveStaff("staff_email", email);
			
			if (result == null) {
				final String path = "staff_photo";
				final Part filePart = request.getPart("photo");

				Staff s = new Staff();
				s.setStaffName(request.getParameter("name"));
				s.setStaffEmail(email);
				s.setStaffPassword(password);
				s.setStaffRole(request.getParameter("role"));
				s.setStaffPhone(request.getParameter("phone"));
				s.setStaffPhoto(cu.uploadFile(LOGGER, path, filePart, request));
				sdb.createStaff(s);

				error = false;
				errorMessage = "";
			} else {
				error = true;
				errorMessage = "'" + email + "' has an existing account. Please try again with a different email.";
			}
		} else {
			error = true;
			errorMessage = "'Password' and 'Confirm Password' are not same.";
		}
		
		session.setAttribute("error", error);
		session.setAttribute("errorMessage", errorMessage);
		doGet(request, response);
	}

}
