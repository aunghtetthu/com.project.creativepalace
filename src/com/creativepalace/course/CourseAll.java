package com.creativepalace.course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.db.CourseDB;
import com.creativepalace.model.Course;

@WebServlet("/custom/course_all")
public class CourseAll extends AbstractServlet {

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
			CourseDB cdb = new CourseDB();
			List<Course> activeCourseList = cdb.retrieveCourse("active");
			List<Course> inactiveCourseList = cdb.retrieveCourse("inactive");
			
			try {
				this.addViewObject("searchResultCount", "");
				this.addViewObject("searchBy", "");
				this.addViewObject("keyword", "");
				
				this.addViewObject("activeCourseCount", activeCourseList.size());
				this.addViewObject("inactiveCourseCount", inactiveCourseList.size());
				this.addViewObject("activeCourseList", activeCourseList);
				this.addViewObject("inactiveCourseList", inactiveCourseList);
				
				this.addViewObject("showSearch", false);
				this.addViewObject("showAll", true);
				
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
		if(request.getParameter("btnSubmit") != null) {
			String fieldName = request.getParameter("searchType");
			String searchKey = request.getParameter("searchKey");
			CourseDB cdb = new CourseDB();
			List<Course> searchResult = cdb.searchCourse(fieldName, searchKey);
			
			try {
				this.addViewObject("searchResultCount", searchResult.size());
				this.addViewObject("searchResult", searchResult);
				
				if(fieldName.equals("course_id")) {
					this.addViewObject("searchBy", "Course ID");
				} else if(fieldName.equals("course_name")) {
					this.addViewObject("searchBy", "Course Name");
				}
				this.addViewObject("keyword", searchKey);
				
				this.addViewObject("showSearch", true);
				this.addViewObject("showAll", false);
				
				this.setHeader("staffHeader");
				this.showView(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
