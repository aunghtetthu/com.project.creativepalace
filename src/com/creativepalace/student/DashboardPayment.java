package com.creativepalace.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.db.PaymentDashboardDB;
import com.creativepalace.model.PaymentDashboard;
import com.creativepalace.model.Student;

@WebServlet("/dashboard_payment")
public class DashboardPayment extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Student s = (Student) session.getAttribute("studentObj");

		try {
			if (s == null) {				
				response.sendRedirect("index");
			} else {
				PaymentDashboardDB pddb = new PaymentDashboardDB();
				List<PaymentDashboard> pdList = pddb.getStudentPayment(s.getStudentID());
				
				if(pdList.size() == 0) {
					this.addViewObject("paymentShow", false);
					this.addViewObject("noPayment", true);
				} else {
					this.addViewObject("paymentShow", true);
					this.addViewObject("noPayment", false);
				}
				
				this.addViewObject("pdList", pdList);
				
				this.setHeader("studentPlainHeader");
				this.showView(request, response);
			}
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
