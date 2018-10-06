package com.creativepalace.db;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			Lecture l = new Lecture();
			LectureDB ldb = new LectureDB();
//			ldb.deleteLecture(Long.parseLong("1"));
			
//			Course c = new Course();
//			CourseDB cdb = new CourseDB();
//			c.setCourseDuration("10 weeks");
//			c.setCourseInfo(
//					"There was, in Brett Kavanaugh’s Trumpian performance, not even a hint of the composure one would think a potential Supreme Court Justice would have carefully cultivated.There was, in Brett Kavanaugh’s Trumpian performance, not even a hint of the composure one would think a potential Supreme Court Justice would have carefully cultivated.There was, in Brett Kavanaugh’s Trumpian performance, not even a hint of the composure one would think a potential Supreme Court Justice would have carefully cultivated.");
//			c.setCourseSyllabus("AI, Python");
//			c.setCoursePrice(new BigDecimal("500000"));
//			c.setCourseStatus("active");
//			c.setCourseID(Long.parseLong("2"));
//			cdb.updateCourse(c);
			
			// CourseDB cdb = new CourseDB();
			// List<Course> cList = cdb.retrieveCourse("active");
			// Iterator<Course> cIterator = cList.iterator();
			// while(cIterator.hasNext()) {
			// Course c = cIterator.next();
			// System.out.println(c.getCourseName());
			// }

			// Course c = cdb.getCourseByName("Test Name");
			// System.out.println(c.getCourseDuration());

			// HttpSession session = request.getSession(true);
			// CourseDB cdb = new CourseDB();
			// Course resultCourse = cdb.getCourseByName("Test Name");
			// session.setAttribute("courseObj", resultCourse);
			// session.setAttribute("successBox", false);
			// session.setAttribute("lectureTitle", "");
			// session.setAttribute("error", false);
			// session.setAttribute("errorMessage", "");

			// LectureDB ldb = new LectureDB();
			// Course c = (Course) session.getAttribute("courseObj");
			// Lecture l = ldb.getLectureByTitle("Lecture Title", c.getCourseID());
			// if(l.getLectureTitle() == null) {
			// System.out.println("This lecture is new.");
			// } else {
			// System.out.println("Existing Lecture.");
			// }

			// LectureDB ldb = new LectureDB();
			// Lecture l = new Lecture();
			// l.setLectureTitle("Lecture Title");
			// l.setLectureVideo("This is video.");
			// l.setLectureDescription("This is description");
			// l.setLecturePdf("This is pdf");
			// l.setCourseID((long)1);
			//
			// ldb.createLecture(l);
			// CourseDB cdb = new CourseDB();
			// Course c = new Course();
			// c.setCourseName("Test Name");
			// c.setCourseDuration("4 weeks");
			// c.setCourseInfo("This is Info.");
			// c.setCourseSyllabus("This is syllabus");
			// c.setCoursePrice(new BigDecimal(20000));
			// c.setCourseCategory("application");
			// c.setCourseCoverPhoto("This is file part");
			// c.setStaffID((long) 1);
			// cdb.createCourse(c);
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
