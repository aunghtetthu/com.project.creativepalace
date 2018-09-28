package com.creativepalace.course;

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
import com.creativepalace.db.LectureDB;
import com.creativepalace.db.StaffDB;
import com.creativepalace.model.Course;
import com.creativepalace.model.Lecture;
import com.creativepalace.model.Staff;

@WebServlet("/custom/course_detail")
public class CourseDetail extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);

		if (session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot access to 'Course' page without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		} else {
			if (request.getParameter("courseID") == null) {
				response.sendRedirect("course_all");
			} else {
				Long courseID = Long.parseLong(request.getParameter("courseID"));
				CourseDB cdb = new CourseDB();
				Course course = cdb.getCourseByID(courseID);
				session.setAttribute("uploadCourse", course);

				StaffDB sdb = new StaffDB();
				Staff staff = sdb.getStaffById(course.getStaffID());

				LectureDB ldb = new LectureDB();
				List<Lecture> lectureList = ldb.retrieveLecture(course.getCourseID());

				ControllerUtility cu = new ControllerUtility();

				try {
					this.addViewObject("courseName", course.getCourseName());
					this.addViewObject("courseCoverPhoto",
							cu.fileLocation(course.getCourseCoverPhoto(), "course_coverPhoto", request));
					this.addViewObject("courseInfo", course.getCourseInfo());
					this.addViewObject("courseSyllabus", course.getCourseSyllabus());
					this.addViewObject("courseDuration", course.getCourseDuration());
					this.addViewObject("coursePrice", course.getCoursePrice());
					this.addViewObject("courseID", course.getCourseID());

					this.addViewObject("staffName", staff.getStaffName());
					this.addViewObject("staffID", staff.getStaffID());

					this.addViewObject("lectureList", lectureList);
					this.addViewObject("showMessage", lectureList == null || lectureList.isEmpty() ? true : false);
					this.addViewObject("showLecture", lectureList == null || lectureList.isEmpty() ? false : true);

					this.setHeader("staffHeader");
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

	}

}
