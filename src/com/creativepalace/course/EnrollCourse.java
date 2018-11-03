package com.creativepalace.course;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.db.StudentCourseDB;
import com.creativepalace.model.Course;
import com.creativepalace.model.Student;

@WebServlet("/enroll_course")
public class EnrollCourse extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long courseID = null;
		Long studentID;
		HttpSession session = request.getSession(true);
		Student student = (Student) session.getAttribute("studentObj");
		studentID = student == null ? null : student.getStudentID();
		
		if(request.getParameter("courseID") != null) {
			courseID = Long.parseLong(request.getParameter("courseID"));
			if(studentID == null) {
				session.setAttribute("enrollCourseID", courseID);
				response.sendRedirect("login");
			}
		} else if (session.getAttribute("enrollCourseID") != null) {
			courseID = (Long) session.getAttribute("enrollCourseID");
			session.removeAttribute("enrollCourseID");
		} else {
			response.sendRedirect("course_all");
		}
		
		StudentCourseDB scdb = new StudentCourseDB();
		if(studentID != null && courseID != null) {
			scdb.enrollCourse(studentID, courseID);
		}
		
		try {
			this.setHeader("studentPlainHeader");
			this.showView(request, response);
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
