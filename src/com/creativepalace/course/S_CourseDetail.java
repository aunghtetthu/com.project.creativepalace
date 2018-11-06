package com.creativepalace.course;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.db.CourseDB;
import com.creativepalace.db.LectureDB;
import com.creativepalace.model.Course;
import com.creativepalace.model.Lecture;
import com.creativepalace.model.Student;

@WebServlet("/course_detail")
public class S_CourseDetail extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long courseID = Long.parseLong(request.getParameter("courseID"));
		HttpSession session = request.getSession(true);
		Student s = (Student) session.getAttribute("studentObj");
		CourseDB cdb = new CourseDB();
		Course course = cdb.getCourseByID(courseID);
		ControllerUtility cu = new ControllerUtility();
		
		LectureDB ldb = new LectureDB();
		ArrayList<Lecture> lectureList = ldb.retrieveLecture(course.getCourseID());
		
		try {
			this.addViewObject("back", request.getParameter("back") == null ? "course_all" : "dashboard_course");
			
			this.addViewObject("courseName", course.getCourseName());
			this.addViewObject("courseCoverPhoto",
					cu.fileLocation(course.getCourseCoverPhoto(), "course_coverPhoto", request));
			this.addViewObject("courseInfo", course.getCourseInfo());
			this.addViewObject("courseSyllabus", course.getCourseSyllabus());
			this.addViewObject("courseDuration", course.getCourseDuration());
			this.addViewObject("coursePrice", course.getCoursePrice());
			this.addViewObject("courseID", course.getCourseID());
			
			this.addViewObject("lectureList", lectureList);
			
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
