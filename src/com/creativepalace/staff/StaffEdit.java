package com.creativepalace.staff;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.db.StaffDB;
import com.creativepalace.model.Staff;

@WebServlet("/custom/staff_edit")
public class StaffEdit extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		ControllerUtility cu = new ControllerUtility();
		
		if (session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"Please log in your account.");
			response.sendRedirect("staff_login");
		} else {
			if (request.getParameter("btnSubmit") == null) {
				cu.showAlertMessage(this, false, "", "");
			}
			
			Staff staff = (Staff) session.getAttribute("staffObj");
			StaffDB sdb = new StaffDB();
			Staff staffData = sdb.getStaffById(staff.getStaffID());
			
			try {
				this.addViewObject("staffID", staffData.getStaffID());
				this.addViewObject("name", staffData.getStaffName());
				this.addViewObject("email", staffData.getStaffEmail());
				this.addViewObject("phonenumber", staffData.getStaffPhone());
				
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
		if (request.getParameter("btnSubmit") != null) {
			Long staffID = Long.parseLong(request.getParameter("staffID"));
			Staff s = new Staff();
			StaffDB sdb = new StaffDB();
			ControllerUtility cu = new ControllerUtility();
			
			s.setStaffName(request.getParameter("name"));
			s.setStaffEmail(request.getParameter("email"));
			s.setStaffPhone(request.getParameter("phone"));
			s.setStaffID(staffID);
			
			sdb.editStaff(s);
			cu.showAlertMessage(this, true, "Your data has been updated successfully.",
					"staff_home");
		}
		
		doGet(request, response);
	}
	
}
