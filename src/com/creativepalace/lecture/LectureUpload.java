package com.creativepalace.lecture;

import java.io.IOException;
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
import com.creativepalace.db.LectureDB;
import com.creativepalace.model.Course;
import com.creativepalace.model.Lecture;

@WebServlet("/custom/lecture_upload")
@MultipartConfig
public class LectureUpload extends AbstractServlet {
	private final static Logger LOGGER = Logger.getLogger(LectureUpload.class.getCanonicalName());

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);

		if (session.getAttribute("staffObj") != null) {
			if (session.getAttribute("uploadCourse") != null) {
				try {
					Course c = (Course) session.getAttribute("uploadCourse");

					this.addViewObject("courseName", c.getCourseName());
					this.addViewObject("successBox", session.getAttribute("successBox"));
					this.addViewObject("lectureTitle", session.getAttribute("lectureTitle"));
					this.addViewObject("error", session.getAttribute("error"));
					this.addViewObject("errorMessage", session.getAttribute("errorMessage"));
					this.setHeader("staffPlainHeader");
					this.showView(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				response.sendRedirect("staff_home");
			}
		} else {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot upload Lecture without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean error;
		boolean successBox;
		String errorMessage;
		HttpSession session = request.getSession(true);

		if (request.getParameter("btnSubmit") != null) {
			String title = request.getParameter("title");
			Course c = (Course) session.getAttribute("uploadCourse");
			
			LectureDB ldb = new LectureDB();
			Lecture result = ldb.getLectureByTitle(title, c.getCourseID());
			if (result.getLectureTitle() == null) {
				final String pdfDestination = "lecture_pdf";
				final Part pdfPart = request.getPart("lecturepdf");
				
				final String videoDestination = "lecture_video";
				final Part videoPart = request.getPart("lecturevideo");
				
				ControllerUtility cu = new ControllerUtility();
				
				Lecture l = new Lecture();
				l.setLectureTitle(title);
				l.setLectureVideo(cu.uploadFile(LOGGER, pdfDestination, pdfPart, request));
				l.setLectureDescription(request.getParameter("description"));
				l.setLecturePdf(cu.uploadFile(LOGGER, videoDestination, videoPart, request));
				l.setCourseID(c.getCourseID());
				ldb.createLecture(l);
				
				error = false;
				errorMessage = "";
				successBox = true;
			} else {
				error = true;
				errorMessage = "'" + title
						+ "' is  the name of existing lecture in the course. Please try again with a different lecture name.";
				successBox = false;
			}
			
			session.setAttribute("error", error);
			session.setAttribute("errorMessage", errorMessage);
			session.setAttribute("successBox", successBox);
			session.setAttribute("lectureTitle", title);
			doGet(request, response);
		}
	}

}
