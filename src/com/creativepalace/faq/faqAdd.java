package com.creativepalace.faq;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.db.FAQDB;
import com.creativepalace.model.FAQ;
import com.creativepalace.model.Staff;

@WebServlet("/custom/FAQ_add")
public class faqAdd extends AbstractServlet {
	ControllerUtility cu = new ControllerUtility();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);

		if (session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot add FAQ without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		} else {
			if (request.getParameter("btnSubmit") == null) {
				cu.showAlertMessage(this, false, "", "");
			}

			try {
				Staff s = (Staff) session.getAttribute("staffObj");
				this.addViewObject("staffID", s.getStaffID());

				this.setHeader("staffHeader");
				this.showView(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("btnSubmit") != null) {
			FAQDB fdb = new FAQDB();
			FAQ faq = new FAQ();
			faq.setQuestion(request.getParameter("question"));
			faq.setAnswer(request.getParameter("answer"));
			faq.setStaffID(Long.parseLong(request.getParameter("staffID")));
			
			fdb.addFAQ(faq);
			
			cu.showAlertMessage(this, true, "FAQ has been added successfully.", "FAQ");
		}
		
		doGet(request, response);
	}

}
