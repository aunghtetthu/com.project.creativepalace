package com.creativepalace.payment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.db.StudentCourseDB;
import com.creativepalace.model.Enrollment;

@WebServlet("/custom/payment_enrollment")
public class PaymentEnrollment extends AbstractServlet {
	private StudentCourseDB scdb = new StudentCourseDB();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);

		if (session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot access to 'Payment Enrollment' page without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		} else {

			try {
				if (request.getParameter("btnSubmit") == null) {
					this.addViewObject("showSearch", false);
					this.addViewObject("noResult", false);
				}

				ArrayList<Enrollment> enrollmentList = scdb.getNewEnrollment();
				if (enrollmentList.size() == 0) {
					this.addViewObject("showEnrollment", false);
					this.addViewObject("noEnrollment", true);
				} else {
					this.addViewObject("showEnrollment", true);
					this.addViewObject("noEnrollment", false);
				}
				
				this.addViewObject("enrollmentList", enrollmentList);
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
		String studentEmail = request.getParameter("studentEmail");
		Long courseID = Long.parseLong(request.getParameter("courseID"));

		List<Enrollment> searchList = scdb.searchEnrollment("pending", studentEmail, courseID);
		this.addViewObject("searchList", searchList);

		if (searchList.size() == 0) {
			this.addViewObject("showSearch", false);
			this.addViewObject("noResult", true);
		} else {
			this.addViewObject("showSearch", true);
			this.addViewObject("noResult", false);
		}

		doGet(request, response);
	}

}
