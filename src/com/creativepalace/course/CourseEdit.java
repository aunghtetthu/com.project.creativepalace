package com.creativepalace.course;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.db.CourseDB;
import com.creativepalace.model.Course;

@WebServlet("/custom/course_edit")
public class CourseEdit extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		ControllerUtility cu = new ControllerUtility();

		if (session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot edit the course without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		} else {
			if (request.getParameter("courseID") == null) {
				response.sendRedirect("course_all");
			} else {
				if (request.getParameter("btnSubmit") == null) {
					cu.showAlertMessage(this, false, "", "");
				}

				Long courseID = Long.parseLong(request.getParameter("courseID"));
				CourseDB cdb = new CourseDB();
				Course c = cdb.getCourseByID(courseID);

				try {
					this.addViewObject("courseName", c.getCourseName());
					this.addViewObject("courseDuration", c.getCourseDuration());
					this.addViewObject("courseInfo", c.getCourseInfo());
					this.addViewObject("courseSyllabus", c.getCourseSyllabus());
					this.addViewObject("coursePrice", c.getCoursePrice());
					this.addViewObject("courseStatus", c.getCourseStatus());
					this.addViewObject("courseID", c.getCourseID());

					this.setHeader("staffPlainHeader");
					this.showView(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("btnSubmit") != null) {
			Long courseID = Long.parseLong(request.getParameter("courseID"));
			Course c = new Course();
			CourseDB cdb = new CourseDB();
			ControllerUtility cu = new ControllerUtility();

			c.setCourseID(courseID);
			c.setCourseDuration(request.getParameter("duration"));
			c.setCourseInfo(request.getParameter("description"));
			c.setCourseSyllabus(request.getParameter("syllabus"));
			c.setCoursePrice(new BigDecimal(request.getParameter("price")));
			c.setCourseStatus(request.getParameter("status"));
			cdb.updateCourse(c);

			cu.showAlertMessage(this, true, "Course Info has been updated successfully.",
					"course_detail?courseID=" + courseID);
		}

		doGet(request, response);
	}

}
