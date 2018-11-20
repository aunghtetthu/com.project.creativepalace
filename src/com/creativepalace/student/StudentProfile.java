package com.creativepalace.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.db.CourseDB;
import com.creativepalace.model.Course;
import com.creativepalace.model.Student;

@WebServlet("/student_profile")
public class StudentProfile extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Student s = (Student) session.getAttribute("studentObj");
		
		try {
			if(s == null) {				
				response.sendRedirect("index");
			} else {
				this.addViewObject("student", true);
				this.addViewObject("guest", false);
				
				ControllerUtility cu = new ControllerUtility();
				
				this.addViewObject("id", s.getStudentID());
				this.addViewObject("studentName", s.getStudentName());
				this.addViewObject("email", s.getStudentEmail());
				this.addViewObject("phone", s.getStudentPhone());
				this.addViewObject("home", s.getStudentHome());
				this.addViewObject("street", s.getStudentStreet());
				this.addViewObject("township", s.getStudentTownship());
				this.addViewObject("city", s.getStudentCity());
				this.addViewObject("photo", cu.fileLocation(s.getStudentPhoto(), "student_photo", request));
				
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
		
	}

}
