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

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.db.StaffDB;
import com.creativepalace.model.Staff;

@WebServlet("/custom/staff_register")
@MultipartConfig
public class StaffRegister extends AbstractServlet {
	private final static Logger LOGGER =
			Logger.getLogger(StaffRegister.class.getCanonicalName());

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		boolean errorExistence;
		String errorMessage;

		ControllerUtility cu = new ControllerUtility();
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
				String password = request.getParameter("password");
				String cPassword = request.getParameter("confirmPassword");
				String email = request.getParameter("email");
				if (password.equals(cPassword)) {
					String sql = "SELECT * FROM staff WHERE staff_email='" + email + "'";
					ArrayList<Staff> result = sdb.reteriveStaff(sql);
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
						
						errorExistence = false;
						errorMessage = "";
						cu.showAlertMessage(this, true, "Your account has been registered successfully. Please log in.",
								"staff_login");
					} else {
						errorExistence = true;
						errorMessage = "'" + email
								+ "' has an existing account. Please try again with a different email.";
					}
				} else {
					errorExistence = true;
					errorMessage = "'Password' and 'Confirm Password' are not same.";
				}
			} else {
				cu.showAlertMessage(this, false, "", "");
			}

			session.setAttribute("error", errorExistence);
			session.setAttribute("errorMessage", errorMessage);
			this.addViewObject("errorExistence", errorExistence);
			this.addViewObject("errorMessage", errorMessage);
			this.setHeader("staffPlainHeader");
			this.showView(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(!isMultipart) {
			System.out.println("There is no file upload.");
		} else 
			System.out.println("This is file upload.");
		doGet(request, response);
	}

}
