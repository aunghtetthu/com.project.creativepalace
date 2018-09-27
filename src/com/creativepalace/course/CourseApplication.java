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

@WebServlet("/custom/course_application")
public class CourseApplication extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot access to 'Course List' page without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		} else {
			String fieldName = "course_category";
			String data = "application";
			CourseDB cdb = new CourseDB();
			List<Course> activeApplicationCourseList = cdb.retrieveCourseByData(fieldName, data, "active");
			List<Course> inactiveApplicationCourseList = cdb.retrieveCourseByData(fieldName, data, "inactive");
			
			try {
				this.addViewObject("activeCount", activeApplicationCourseList.size());
				this.addViewObject("inactiveCount", inactiveApplicationCourseList.size());
				
				this.addViewObject("activeList", activeApplicationCourseList);
				this.addViewObject("inactiveList", inactiveApplicationCourseList);
				
				this.setHeader("staffHeader");
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
		
	}

}
