package com.creativepalace.certificate;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.course.CourseUpload;
import com.creativepalace.db.CertificateDB;
import com.creativepalace.model.Certificate;

@WebServlet("/custom/certificate_upload")
@MultipartConfig
public class CertificateUpload extends AbstractServlet {
	private final static Logger LOGGER = Logger.getLogger(CourseUpload.class.getCanonicalName());
	private ControllerUtility cu = new ControllerUtility();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("staffObj") == null) {
			response.sendRedirect("staff_login");
		} else {
			final String destination = "certificate";
			final Part filePart = request.getPart("certificate");
			
			CertificateDB cdb = new CertificateDB();
			Certificate c = new Certificate();
			
			c.setCertificatePDF(cu.uploadFile(LOGGER, destination, filePart, request));
			c.setStudentCourseID(Long.parseLong(request.getParameter("studentCourseID")));
			
			cdb.createCertificate(c);
			cu.showAlertMessage(this, true, "Certificate has been uploaded.", "certificate_candidate");
			
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
