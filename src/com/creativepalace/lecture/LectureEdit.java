package com.creativepalace.lecture;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.db.LectureDB;
import com.creativepalace.model.Lecture;

@WebServlet("/custom/lecture_edit")
public class LectureEdit extends AbstractServlet {
	private ControllerUtility cu = new ControllerUtility();
	private LectureDB ldb = new LectureDB();
	private Lecture l = new Lecture();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);

		if (session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot edit the lecture without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		} else {
			if (request.getParameter("lectureID") == null) {
				response.sendRedirect("course_all");
			} else {
				if (request.getParameter("btnSubmit") == null) {
					cu.showAlertMessage(this, false, "", "");
				}

				Long lectureID = Long.parseLong(request.getParameter("lectureID"));
				l = ldb.getLectureByID(lectureID);

				try {
					this.addViewObject("courseID", l.getCourseID());
					this.addViewObject("lectureTitle", l.getLectureTitle());
					this.addViewObject("lectureDescription", l.getLectureDescription());
					this.addViewObject("lectureID", l.getLectureID());

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
			Long lectureID = Long.parseLong(request.getParameter("lectureID"));
			
			l.setLectureID(lectureID);
			l.setLectureDescription(request.getParameter("description"));
			ldb.updateLecture(l);
			
			cu.showAlertMessage(this, true, "Lecture description has been updated successfully.", "lecture_detail?lectureID="+lectureID);
		}
		
		doGet(request, response);
	}

}
