package com.creativepalace.lecture;

import java.io.IOException;

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

@WebServlet("/custom/lecture_detail")
public class LectureDetail extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot see Lecture without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		} else {
			
			if(request.getParameter("lectureID") == null) {
				response.sendRedirect("staff_home");
			} else {
				long lectureID = Long.parseLong(request.getParameter("lectureID"));
				
				LectureDB ldb = new LectureDB();
				Lecture lecture = ldb.getLectureByID(lectureID);
				
				CourseDB cdb = new CourseDB();
				Course course = cdb.getCourseByID(lecture.getCourseID());
				
				ControllerUtility cu = new ControllerUtility();
				
				try {
					this.addViewObject("courseID", course.getCourseID());
					this.addViewObject("courseName", course.getCourseName());
					
					this.addViewObject("lectureTitle", lecture.getLectureTitle());
					this.addViewObject("lectureDescription", lecture.getLectureDescription());
					this.addViewObject("lectureVideo", cu.fileLocation(lecture.getLectureVideo(), "lecture_video", request));
					this.addViewObject("lecturePDF", cu.fileLocation(lecture.getLecturePdf(), "lecture_pdf", request));
					this.addViewObject("lectureID", lecture.getLectureID());
					
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
