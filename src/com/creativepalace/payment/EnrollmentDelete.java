package com.creativepalace.payment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.db.PaymentDB;
import com.creativepalace.db.StudentCourseDB;

@WebServlet("/custom/enrollment_delete")
public class EnrollmentDelete extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		ControllerUtility cu = new ControllerUtility();
		
		if (session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot access to 'Payment Enrollment' page without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		} else {
			
			if(request.getParameter("studentCourseID") == null) {
				response.sendRedirect("payment_enrollment");
			} else {
				Long studentCourseID = Long.parseLong(request.getParameter("studentCourseID"));
												
				StudentCourseDB scdb = new StudentCourseDB();
				scdb.deleteEnroll(studentCourseID);
				cu.showAlertMessage(this, true, "Enrollment has been deleted.", "payment_enrollment");
				
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
