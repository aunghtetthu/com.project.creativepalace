package com.creativepalace.student;

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

@WebServlet("/dashboard_course")
public class DashboardCourse extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Student s = (Student) session.getAttribute("studentObj");
		
		try {
			if(s == null) {
				response.sendRedirect("index");
			} else {
				CourseDB cdb = new CourseDB();
				List<Course> courseList = cdb.courseEnrolledByStudent(s.getStudentID());
				
				if(courseList.size() == 0) {
					this.addViewObject("courseShow", false);
					this.addViewObject("noCourse", true);
				} else {
					this.addViewObject("courseShow", true);
					this.addViewObject("noCourse", false);
				}
				
				this.addViewObject("courseList", courseList);
				
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
		
	}

}
