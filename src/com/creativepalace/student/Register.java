package com.creativepalace.student;

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
import com.creativepalace.db.StudentDB;
import com.creativepalace.model.Student;

@WebServlet("/user/register")
@MultipartConfig
public class Register extends AbstractServlet {
	private ControllerUtility cu = new ControllerUtility();
	private final static Logger LOGGER = Logger.getLogger(Register.class.getCanonicalName());
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);

		if (session.getAttribute("studentObj") != null) {
			response.sendRedirect("index");
		} else {
			if (session.isNew()) {
				session.setAttribute("error", false);
				session.setAttribute("errorMessage", "");
			}

			if (request.getParameter("btnSubmit") != null && (boolean) session.getAttribute("error") == false) {
				cu.showAlertMessage(this, true, "Your account has been registered successfully. Please log in.", "login");
			} else {
				cu.showAlertMessage(this, false, "", "");
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
		HttpSession session = request.getSession(true);

		String password = request.getParameter("password");
		String cPassword = request.getParameter("confrimPassword");
		String email = request.getParameter("email");
		if (password.equals(cPassword)) {
			StudentDB sdb = new StudentDB();
			ArrayList<Student> studentList = sdb.retrieveStudent("student_email", email);

			if (studentList == null) {
				final String PATH = "student_photo";
				final Part FILEPART = request.getPart("photo");
				
				Student s = new Student();
				s.setStudentName(request.getParameter("name"));
				s.setStudentEmail(email);
				s.setStudentPassword(password);
				s.setStudentPhone(request.getParameter("phoneNum"));
				s.setStudentPhoto(cu.uploadFile(LOGGER, PATH, FILEPART, request));
				s.setStudentHome(request.getParameter("homeno"));
				s.setStudentStreet(request.getParameter("street"));
				s.setStudentTownship(request.getParameter("township"));
				s.setStudentCity(request.getParameter("city"));
				sdb.createStudent(s);
				
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
