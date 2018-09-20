package com.creativepalace.db;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.creativepalace.controller.AbstractServlet;
import com.creativepalace.model.Course;
import com.creativepalace.model.Lecture;
import com.creativepalace.model.Staff;

@WebServlet("/testMe")
public class TestDB extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
//			LectureDB ldb = new LectureDB();
//			Lecture l = new Lecture();
//			l.setLectureTitle("Lecture Title");
//			l.setLectureVideo("This is video.");
//			l.setLectureDescription("This is description");
//			l.setLecturePdf("This is pdf");
//			l.setCourseID((long)1);
//			
//			ldb.createLecture(l);
//			CourseDB cdb = new CourseDB();
//			Course c = new Course();
//			c.setCourseName("Test Name");
//			c.setCourseDuration("4 weeks");
//			c.setCourseInfo("This is Info.");
//			c.setCourseSyllabus("This is syllabus");
//			c.setCoursePrice(new BigDecimal(20000));
//			c.setCourseCategory("application");
//			c.setCourseCoverPhoto("This is file part");
//			c.setStaffID((long) 1);
//			cdb.createCourse(c);
//			
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
