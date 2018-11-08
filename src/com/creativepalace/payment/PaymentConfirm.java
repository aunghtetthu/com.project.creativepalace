package com.creativepalace.payment;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.db.PaymentDB;
import com.creativepalace.model.Payment;
import com.creativepalace.model.Staff;

@WebServlet("/custom/payment_confirm")
public class PaymentConfirm extends AbstractServlet {

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
				Staff s = (Staff) session.getAttribute("staffObj");
				Long staffID = s.getStaffID();
				Long studentCourseID = Long.parseLong(request.getParameter("studentCourseID"));
				
				Payment p = new Payment();
				p.setPaymentAmount(new BigDecimal(request.getParameter("coursePrice")));
				p.setStaffID(staffID);
				p.setStudentCourseID(studentCourseID);
				
				PaymentDB pdb = new PaymentDB();
				pdb.recordPayment(p);
				cu.showAlertMessage(this, true, "Payment has been confirmed", "payment_paid");
				
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
