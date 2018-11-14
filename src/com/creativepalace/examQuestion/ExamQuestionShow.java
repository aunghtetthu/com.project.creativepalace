package com.creativepalace.examQuestion;

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
import com.creativepalace.db.ExamQuestionDB;
import com.creativepalace.model.Course;
import com.creativepalace.model.ExamQuestion;

@WebServlet("/custom/exam_question")
public class ExamQuestionShow extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot view exam question without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		} else {
			if (request.getParameter("courseID") == null) {
				response.sendRedirect("course_all");
			} else {
				Long courseID = Long.parseLong(request.getParameter("courseID"));
				ExamQuestionDB eqdb = new ExamQuestionDB();
				List<ExamQuestion> eqList = eqdb.retrieveExamQuestion(courseID);
				
				CourseDB cdb = new CourseDB();
				Course c = cdb.getCourseByID(courseID);
				
				try {
					this.addViewObject("courseID", c.getCourseID());
					this.addViewObject("courseName", c.getCourseName());
					this.addViewObject("eqList", eqList);
					
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
		
	}

}
