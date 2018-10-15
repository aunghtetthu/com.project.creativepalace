package com.creativepalace.course;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.db.CourseDB;
import com.creativepalace.model.Course;
import com.creativepalace.model.Student;

@WebServlet("/course_application")
public class S_CourseApplication extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Student s = (Student) session.getAttribute("studentObj");
		
		CourseDB cdb = new CourseDB();
		List<Course> courseList = cdb.retrieveCourseByData("course_category", "application", "active");
		
		try {
			if (s == null) {
				this.addViewObject("student", false);
				this.addViewObject("guest", true);
			} else {
				this.addViewObject("student", true);
				this.addViewObject("guest", false);
			}
			
			this.addViewObject("studentID", s == null ? "" : s.getStudentID());
			this.addViewObject("studentName", s == null ? "" : s.getStudentName());
			
			this.addViewObject("courseCount", courseList.size());
			this.addViewObject("courseList", courseList);
			
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
