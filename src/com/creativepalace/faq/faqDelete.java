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

@WebServlet("/custom/FAQ_delete")
public class faqDelete extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot delete FAQ without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		} else {
			Long faqid = Long.parseLong(request.getParameter("faqid"));
			
			FAQDB fdb = new FAQDB();
			fdb.deleteFAQ(faqid);
			
			ControllerUtility cu = new ControllerUtility();
			cu.showAlertMessage(this, true, "FAQ has been deleted successfully",
					"FAQ");
			
			try {
				this.setHeader("staffPlainHeader");
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
		
	}

}
