package com.creativepalace.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.controller.ControllerUtility;
import com.creativepalace.db.StudentDB;
import com.creativepalace.model.Student;

@WebServlet("/custom/student_list")
public class StudentList extends AbstractServlet {
	private StudentDB sdb = new StudentDB();
	private ControllerUtility cu = new ControllerUtility();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);

		if (session.getAttribute("staffObj") == null) {
			session.setAttribute("error", true);
			session.setAttribute("errorMessage",
					"You cannot view student list without your account. Firstly, please log in your account.");
			response.sendRedirect("staff_login");
		} else {
			try {
				if (request.getParameter("btnSubmit") == null) {
					this.addViewObject("searchKey", "");
					this.addViewObject("showSearch", false);
					this.addViewObject("noResult", false);
				}
				
				List<Student> sList = sdb.retrieveStudent();
				if (sList.size() == 0) {
					this.addViewObject("showStudent", false);
					this.addViewObject("noStudent", true);
				} else {
					this.addViewObject("showStudent", true);
					this.addViewObject("noStudent", false);
				}
				
				this.addViewObject("sList", sList);
				this.addViewObject("totalStudent", sList.size());
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
		List<Student> searchList = sdb.retrieveStudent("student_email", studentEmail);
		
		this.addViewObject("searchList", searchList);
		this.addViewObject("searchKey", studentEmail);
		
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
