package com.creativepalace.course;

import java.io.IOException;
import java.math.BigDecimal;
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
import com.creativepalace.db.CourseDB;
import com.creativepalace.model.Course;
import com.creativepalace.model.Staff;
import com.mysql.cj.Session;

@WebServlet("/custom/course_upload")
@MultipartConfig
public class CourseUpload extends AbstractServlet {
	private final static Logger LOGGER = Logger.getLogger(CourseUpload.class.getCanonicalName());

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		ControllerUtility cu = new ControllerUtility();

		if (session.getAttribute("staffObj") != null) {
			if(request.getParameter("btnSubmit") == null) {
				cu.showAlertMessage(this, false, "", "");
			}
			try {
				this.addViewObject("error", session.getAttribute("error"));
				this.addViewObject("errorMessage", session.getAttribute("errorMessage"));
				this.setHeader("staffPlainHeader");
				this.showView(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot upload Course without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean error;
		String errorMessage;
		HttpSession session = request.getSession(true);

		if (request.getParameter("btnSubmit") != null) {
			String courseName = request.getParameter("name");
			CourseDB cdb = new CourseDB();
			Course result = cdb.getCourseByName(courseName);
			if (result.getCourseName() == null) {
				final String destination = "course_coverPhoto";
				final Part filePart = request.getPart("photo");

				ControllerUtility cu = new ControllerUtility();
				Staff s = (Staff) session.getAttribute("staffObj");

				Course c = new Course();
				c.setCourseName(courseName);
				c.setCourseDuration(request.getParameter("duration"));
				c.setCourseInfo(request.getParameter("description"));
				c.setCourseSyllabus(request.getParameter("syllabus"));
				c.setCoursePrice(new BigDecimal(request.getParameter("price")));
				c.setCourseCategory(request.getParameter("category"));
				c.setCourseCoverPhoto(cu.uploadFile(LOGGER, destination, filePart, request));
				c.setStaffID(s.getStaffID());
				cdb.createCourse(c);

				Course resultCourse = cdb.getCourseByName(courseName);
				System.out.println(resultCourse.getCourseID());
				System.out.println(resultCourse.getCourseName());

				error = false;
				errorMessage = "";
				session.setAttribute("courseObj", resultCourse);
				session.setAttribute("successBox", false);
				session.setAttribute("lectureTitle", "");
				cu.showAlertMessage(this, true, "Information of " + resultCourse.getCourseName()
						+ " has been uploaded successfully. Please continue upload lectures.", "lecture_upload");

			} else {
				error = true;
				errorMessage = "'" + courseName
						+ "' is  the name of existing course. Please try again with a different course name.";
			}

			session.setAttribute("error", error);
			session.setAttribute("errorMessage", errorMessage);
			doGet(request, response);
		}
	}

}
