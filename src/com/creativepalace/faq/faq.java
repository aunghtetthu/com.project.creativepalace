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
import com.creativepalace.model.Staff;

@WebServlet("/custom/FAQ")
public class faq extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);

		if (session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot view FAQ without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		} else {
			FAQDB fdb = new FAQDB();
			List<FAQ> fList = fdb.retrieveFAQ();
			
			if(fList.size() == 0) {
				this.addViewObject("faqShow", false);
				this.addViewObject("noFAQ", true);
			} else {
				this.addViewObject("faqShow", true);
				this.addViewObject("noFAQ", false);
			}
			
			try {
				this.addViewObject("fList", fList);
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
		
	}

}
