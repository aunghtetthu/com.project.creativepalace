package com.creativepalace.faq;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.db.FAQDB;
import com.creativepalace.model.FAQ;
import com.creativepalace.model.Student;

@WebServlet("/FAQ")
public class S_faq extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Student s = (Student) session.getAttribute("studentObj");
		
		try {
			if (s == null) {
				this.addViewObject("student", false);
				this.addViewObject("guest", true);
			} else {
				this.addViewObject("student", true);
				this.addViewObject("guest", false);
			}
			
			this.addViewObject("studentID", s == null ? "" : s.getStudentID());
			this.addViewObject("studentName", s == null ? "" : s.getStudentName());
			
			FAQDB fdb = new FAQDB();
			List<FAQ> fList = fdb.retrieveFAQ();
			
			if(fList.size() == 0) {
				this.addViewObject("faqShow", false);
				this.addViewObject("noFAQ", true);
			} else {
				this.addViewObject("faqShow", true);
				this.addViewObject("noFAQ", false);
			}
			
			this.addViewObject("fList", fList);
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
