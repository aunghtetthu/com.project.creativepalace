package com.creativepalace.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.db.CertificateDB;
import com.creativepalace.model.IssueCertificate;
import com.creativepalace.model.Student;

@WebServlet("/dashboard_certificate")
public class DashboardCertificate extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Student s = (Student) session.getAttribute("studentObj");
		
		try {
			if(s == null) {
				response.sendRedirect("index");
			} else {
				CertificateDB cdb = new CertificateDB();
				List<IssueCertificate> icList = cdb.certificateDashboard(s.getStudentID());
				
				if(icList.size() == 0) {
					this.addViewObject("certificateShow", false);
					this.addViewObject("noCertificate", true);
				} else {
					this.addViewObject("certificateShow", true);
					this.addViewObject("noCertificate", false);
				}
								
				this.addViewObject("icList", icList);
				
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
