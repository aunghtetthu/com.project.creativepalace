package com.creativepalace.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.db.StaffDB;
import com.creativepalace.db.StudentDB;
import com.creativepalace.model.Staff;
import com.creativepalace.model.Student;

@WebServlet("/student_edit")
public class StudentEdit extends AbstractServlet {
	ControllerUtility cu = new ControllerUtility();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Student s = (Student) session.getAttribute("studentObj");
		
		try {
			if(s == null) {				
				response.sendRedirect("index");
			} else {
				if (request.getParameter("btnSubmit") == null) {
					cu.showAlertMessage(this, false, "", "");
				}
								
				this.addViewObject("email", s.getStudentEmail());
				this.addViewObject("name", s.getStudentName());
				this.addViewObject("phone", s.getStudentPhone());
				this.addViewObject("home", s.getStudentHome());
				this.addViewObject("street", s.getStudentStreet());
				this.addViewObject("township", s.getStudentTownship());
				this.addViewObject("city", s.getStudentCity());
				
				this.setHeader("studentPlainHeader");
				this.showView(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("btnSubmit") != null) {
			String studentEmail = request.getParameter("email");
			Student s = new Student();
			StudentDB sdb = new StudentDB();			
			ControllerUtility cu = new ControllerUtility();
			
			s.setStudentEmail(studentEmail);
			s.setStudentName(request.getParameter("name"));
			s.setStudentPhone(request.getParameter("phoneNum"));
			s.setStudentHome(request.getParameter("homeno"));
			s.setStudentStreet(request.getParameter("street"));
			s.setStudentTownship(request.getParameter("township"));
			s.setStudentCity(request.getParameter("city"));
			
			sdb.editStudent(s);
			cu.showAlertMessage(this, true, "Your data has been updated successfully. Please log in again.",
					"logout");
		}
		
		doGet(request, response);
	}

}
