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

@WebServlet("/custom/exam_question_edit")
public class ExamQuestionEdit extends AbstractServlet {

	private ControllerUtility cu = new ControllerUtility();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);

		if (session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot edit exam question without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		} else {
			if (request.getParameter("examQuestionID") == null) {
				response.sendRedirect("course_all");
			} else {
				if (request.getParameter("btnSubmit") == null) {
					cu.showAlertMessage(this, false, "", "");
				}

				Long examQuestionID = Long.parseLong(request.getParameter("examQuestionID"));
				Long courseID = Long.parseLong(request.getParameter("courseID"));
				ExamQuestionDB eqdb = new ExamQuestionDB();
				ExamQuestion eq = eqdb.getExamQuestion(examQuestionID);

				CourseDB cdb = new CourseDB();
				Course c = cdb.getCourseByID(courseID);

				try {
					this.addViewObject("courseID", courseID);
					this.addViewObject("courseName", c.getCourseName());

					this.addViewObject("examQuestionID", examQuestionID);
					this.addViewObject("questionNumber", eq.getQuestionNumber());
					this.addViewObject("question", eq.getQuestion());
					this.addViewObject("choice1", eq.getChoice1());
					this.addViewObject("choice2", eq.getChoice2());
					this.addViewObject("choice3", eq.getChoice3());
					this.addViewObject("choice4", eq.getChoice4());
					this.addViewObject("choice5", eq.getChoice5());
					this.addViewObject("answer", eq.getAnswer());

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
			Long examQuestionID = Long.parseLong(request.getParameter("examQuestionID"));

			ExamQuestion eq = new ExamQuestion();
			ExamQuestionDB eqdb = new ExamQuestionDB();

			eq.setExamQuestionID(examQuestionID);
			eq.setQuestionNumber(Integer.parseInt(request.getParameter("questionNumber")));
			eq.setQuestion(request.getParameter("question"));
			eq.setChoice1(request.getParameter("choice1"));
			eq.setChoice2(request.getParameter("choice2"));
			eq.setChoice3(request.getParameter("choice3"));
			eq.setChoice4(request.getParameter("choice4"));
			eq.setChoice5(request.getParameter("choice5"));
			eq.setAnswer(request.getParameter("answer"));

			eqdb.editExamQuestion(eq);

			cu.showAlertMessage(this, true, "Question has been updated successfully.",
					"exam_question?courseID=" + courseID);
		}
		
		doGet(request, response);
	}

}
