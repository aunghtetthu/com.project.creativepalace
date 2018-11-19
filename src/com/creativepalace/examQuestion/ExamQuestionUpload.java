package com.creativepalace.examQuestion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.db.CourseDB;
import com.creativepalace.db.ExamQuestionDB;
import com.creativepalace.model.Course;
import com.creativepalace.model.ExamQuestion;

@WebServlet("/custom/exam_question_upload")
public class ExamQuestionUpload extends AbstractServlet {

	private ControllerUtility cu = new ControllerUtility();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);

		if (session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot upload exam question without your account. Firstly, please log in your account.");
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
					this.addViewObject("courseID", c.getCourseID());
					this.addViewObject("courseName", c.getCourseName());
					
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
		if(request.getParameter("btnSubmit") != null) {
			Long courseID = Long.parseLong(request.getParameter("courseID"));
			ExamQuestion eq = new ExamQuestion();
			ExamQuestionDB eqdb = new ExamQuestionDB();
			
			eq.setQuestionNumber(Integer.parseInt(request.getParameter("questionNumber")));
			eq.setQuestion(request.getParameter("question"));
			eq.setChoice1(request.getParameter("choice1"));
			eq.setChoice2(request.getParameter("choice2"));
			eq.setChoice3(request.getParameter("choice3"));
			eq.setChoice4(request.getParameter("choice4"));
			eq.setChoice5(request.getParameter("choice5"));
			eq.setAnswer(request.getParameter("answer"));
			eq.setMark(Integer.parseInt(request.getParameter("mark")));
			eq.setCourseID(courseID);
			eqdb.addExamQuestion(eq);
			
			cu.showAlertMessage(this, true, "Question has been added successfully.", "exam_question?courseID="+courseID);
		}
		
		doGet(request, response);
	}

}
