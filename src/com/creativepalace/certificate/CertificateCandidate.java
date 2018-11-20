package com.creativepalace.certificate;

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

@WebServlet("/custom/certificate_candidate")
public class CertificateCandidate extends AbstractServlet {
	CertificateDB cdb = new CertificateDB();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);

		if (session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot issue certificate without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		} else {
			try {
				if (request.getParameter("btnSubmit") == null) {
					this.addViewObject("showSearch", false);
					this.addViewObject("noResult", false);
				}
				
				List<IssueCertificate> icList = cdb.getCandidates();
				if (icList.size() == 0) {
					this.addViewObject("showCandidate", false);
					this.addViewObject("noCandidate", true);
				} else {
					this.addViewObject("showCandidate", true);
					this.addViewObject("noCandidate", false);
				}
				
				this.addViewObject("icList", icList);
				
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
		List<IssueCertificate> searchList = cdb.getCandidatesByEmail(studentEmail);
		
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
