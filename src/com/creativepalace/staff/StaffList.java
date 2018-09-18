package com.creativepalace.staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.db.StaffDB;
import com.creativepalace.model.Staff;

@WebServlet("/custom/staff_list")
public class StaffList extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String fieldName = "";
		String data = "";
		String resultCount = "";
		String adminCount = "";
		String financeCount = "";
		String teacherCount = "";
		
		ControllerUtility cu = new ControllerUtility();
		
		try {
			if (session.getAttribute("staffObj") != null) {
				StaffDB sdb = new StaffDB();
				
				if (request.getParameter("btnSubmit") != null) {
					fieldName = request.getParameter("searchType");
					data = request.getParameter("searchKey");
					List<Staff> resultList = sdb.reteriveStaff(fieldName, data);
					resultCount = cu.checkList(resultList);
					
					if(resultList == null) {
						resultList = new ArrayList<Staff>();
						Staff s = new Staff();
						s.setStaffID((long) 0);
						s.setStaffName("-");
						s.setStaffEmail("-");
						s.setStaffPhone("-");
						s.setStaffRole("-");
						resultList.add(s);
					}
										
					this.addViewObject("resultCount", resultList.size());
					this.addViewObject("resultList", resultList);
					
					this.addViewObject("showAll", false);
					this.addViewObject("searchResult", true);
				} else {
//					ArrayList<Staff> adminList = sdb.reteriveStaff("staff_role", "admin");
					List<Staff> adminList = sdb.reteriveStaff("staff_role", "admin");
					List<Staff> financeList = sdb.reteriveStaff("staff_role", "finance-staff");
					List<Staff> teacherList = sdb.reteriveStaff("staff_role", "teacher");
					
					adminCount = cu.checkList(adminList);
					financeCount = cu.checkList(financeList);
					teacherCount = cu.checkList(teacherList);
					
					this.addViewObject("adminCount", adminList.size());
					this.addViewObject("adminList", adminList);
					
					this.addViewObject("financeCount", financeList.size());
					this.addViewObject("financeList", financeList);
					
					this.addViewObject("teacherCount", teacherList.size());
					this.addViewObject("teacherList", teacherList);
					
					this.addViewObject("showAll", true);
					this.addViewObject("searchResult", false);
				}
			} else {
				session.setAttribute("error", true);
				session.setAttribute("errorMessage",
						"You cannot access to 'Staff List' page without your account. Firstly, please log in your account.");
				response.sendRedirect("staff_login");
			}
			
//			this.addViewObject("showAll", false);
//			this.addViewObject("searchResult", true);
			if(fieldName.equals("staff_id")) {
				fieldName = "Staff ID";
			} else if(fieldName.equals("staff_email")) {
				fieldName = "Email";
			} else if(fieldName.equals("staff_name")) {
				fieldName = "Name";
			}
			
			this.addViewObject("fieldName", fieldName);
			this.addViewObject("data", data);
			
			this.addViewObject("resultCount", resultCount);
			this.addViewObject("adminCount", adminCount);
			this.addViewObject("financeCount", financeCount);
			this.addViewObject("teacherCount", teacherCount);
			
			this.setHeader("staffHeader");
			this.showView(request, response);
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
