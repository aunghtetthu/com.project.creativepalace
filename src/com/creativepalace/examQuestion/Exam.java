package com.creativepalace.examQuestion;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.db.ExamQuestionDB;
import com.creativepalace.db.StudentCourseDB;
import com.creativepalace.model.ExamQuestion;
import com.creativepalace.model.Student;

@WebServlet("/exam")
public class Exam extends AbstractServlet {

	ExamQuestionDB eqdb = new ExamQuestionDB();
	ControllerUtility cu = new ControllerUtility();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Student s = (Student) session.getAttribute("studentObj");

		if (s == null) {
			response.sendRedirect("index");
		} else {
			if (request.getParameter("courseID") == null) {
				response.sendRedirect("dashboard_exam");
			} else {
				if (request.getParameter("btnSubmit") == null) {
					cu.showAlertMessage(this, false, "", "");
				}
				
				Long courseID = Long.parseLong(request.getParameter("courseID"));
				String courseName = request.getParameter("courseName");
				
				List<ExamQuestion> eqList = eqdb.retrieveExamQuestion(courseID);
				
				try {
					this.addViewObject("courseID", courseID == null ? "" : courseID);
					this.addViewObject("courseName", courseName == null ? "" : courseName);
					this.addViewObject("eqList", eqList);
					
					this.setHeader("studentPlainHeader");
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
			
			HttpSession session = request.getSession(true);
			Student s = (Student) session.getAttribute("studentObj");
			
			List<ExamQuestion> eqList = eqdb.retrieveExamQuestion(courseID);
			Iterator<ExamQuestion> eqIterator = eqList.iterator();
			
			int mark = 0;
			while(eqIterator.hasNext()) {
				ExamQuestion eq = eqIterator.next();
				String answer = request.getParameter("answer"+eq.getQuestionNumber());
				if(eq.getAnswer().equals(answer)) {
					mark = mark + eq.getMark();
				}
			}
			
			StudentCourseDB scdb = new StudentCourseDB();
			scdb.updateMarkAndType(courseID, s.getStudentID(), mark, "candidate");
			
			cu.showAlertMessage(this, true, "Your mark is " + mark +". We will contact you soon for certificate. So stay tuned.", "dashboard_course");
		}
		
		doGet(request, response);
	}

}
