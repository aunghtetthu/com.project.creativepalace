package com.creativepalace.examQuestion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.db.ExamQuestionDB;

@WebServlet("/custom/exam_question_delete")
public class ExamQuestionDelete extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		if (session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot delete the exam question without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		} else {
			if (request.getParameter("examQuestionID") == null) {
				response.sendRedirect("course_all");
			} else {
				Long examQuestionID = Long.parseLong(request.getParameter("examQuestionID"));
				Long courseID = Long.parseLong(request.getParameter("courseID"));
				ExamQuestionDB eqdb = new ExamQuestionDB();
				eqdb.deleteExamQuestion(examQuestionID);

				ControllerUtility cu = new ControllerUtility();
				cu.showAlertMessage(this, true, "Exam Question has been deleted successfully",
						"exam_question?courseID=" + courseID);
				
				try {
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
