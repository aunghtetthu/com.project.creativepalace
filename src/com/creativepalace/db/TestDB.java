package com.creativepalace.db;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.model.Staff;

@WebServlet("/testMe")
public class TestDB extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			StaffDB sdb = new StaffDB();
//			Staff s = new Staff();
//			s.setStaffName("Test Name");
//			s.setStaffEmail("test email");
//			s.setStaffPassword("1234");
//			s.setStaffPhone("12345");
//			s.setStaffPhoto("This is photo");
//			s.setStaffRole("admin");
//			sdb.createStaff(s);
			String email = "testemail@gmail.com";
			String sql = "SELECT * FROM staff WHERE staff_email='" + email + "'";
			ArrayList<Staff> result = sdb.reteriveStaff(sql);
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
