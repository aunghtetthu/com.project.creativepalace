package com.creativepalace.staff;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.model.Staff;

@WebServlet("/custom/staff_home")
public class StaffHome extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("staffObj") != null) {
			try {
				Staff s = (Staff) session.getAttribute("staffObj");
				
				this.setHeader("staffHeader");
				
				this.addViewObject("name", s.getStaffName());
				this.addViewObject("role", s.getStaffRole());
				this.addViewObject("email", s.getStaffEmail());
				this.addViewObject("phone", s.getStaffPhone());
				this.addViewObject("photo", s.getStaffPhoto());
				
				this.showView(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage", "You cannot access to 'Staff Home' page without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		};
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
