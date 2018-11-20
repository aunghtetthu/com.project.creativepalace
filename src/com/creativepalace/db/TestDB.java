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
import com.creativepalace.model.Certificate;
import com.creativepalace.model.Course;
import com.creativepalace.model.Enrollment;
import com.creativepalace.model.ExamQuestion;
import com.creativepalace.model.IssueCertificate;
import com.creativepalace.model.Lecture;
import com.creativepalace.model.Payment;
import com.creativepalace.model.Staff;
import com.creativepalace.model.Student;
import com.creativepalace.model.StudentCourse;

@WebServlet("/testMe")
public class TestDB extends AbstractServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
//			CertificateDB cdb = new CertificateDB();
//			List<IssueCertificate> searchList = cdb.getCandidatesByEmail("aung@gmail.com");
//			System.out.println("Search List size:" + searchList.size());
//			Iterator<IssueCertificate> it = searchList.iterator();
//			while(it.hasNext()) {
//				IssueCertificate is = it.next();
//				System.out.println("it is " +is.getStudentName());
//			}
//			Certificate c = new Certificate();
//			c.setCertificatePDF("This is pdf");
//			c.setStudentCourseID(Long.parseLong("3"));
//			
//			CertificateDB cdb = new CertificateDB();
//			cdb.createCertificate(c);
			
//			ExamQuestion eq = new ExamQuestion();
//			eq.setQuestion("This is question");
//			eq.setQuestionNumber(1);
//			eq.setChoice1("This is choice1.");
//			eq.setChoice2("This is choice2 is good.");
//			eq.setChoice3("This is choice3.");
//			eq.setChoice4("This is choice4.");
//			eq.setChoice5("This is choice5.");
//			eq.setAnswer("This is answer.");
//			eq.setCourseID(Long.parseLong("1"));
//			eq.setExamQuestionID(Long.parseLong("1"));
//			
//			ExamQuestionDB eqdb = new ExamQuestionDB();
//			eqdb.deleteExamQuestion(Long.parseLong("1"));
//			eqdb.editExamQuestion(eq);
//			ArrayList<ExamQuestion> eqList = eqdb.retrieveExamQuestion(Long.parseLong("1"));
//			Iterator<ExamQuestion> eqIterator = eqList.iterator();
//			while(eqIterator.hasNext()) {
//				ExamQuestion tempEq = eqIterator.next();
//				System.out.println(tempEq.getAnswer());
//			}
//			ExamQuestion req = eqdb.getExamQuestion(Long.parseLong("1"));
//			System.out.println(req.getQuestion());
//			eqdb.addExamQuestion(eq);
			
//			eq = 
			
//			StudentCourseDB scdb = new StudentCourseDB();
//			ArrayList<Enrollment> en = scdb.getNewEnrollment();
//			Iterator<Enrollment> eI = en.iterator();
//			while(eI.hasNext()) {
//				Enrollment enroll = eI.next();
//				System.out.println("Course Name: " + enroll.getCourseName());
//			}
			
//			PaymentDB pdb = new PaymentDB();
//			Payment p = pdb.checkPayment((long)1, (long)2);
//			
//			System.out.println(p.getPaymentDate());
			
			
//			StudentCourseDB scdb = new StudentCourseDB();
//			Long studentID = (long) 1;
//			Long courseID = (long) 1;
//			StudentCourse sc = scdb.getEnroll(studentID, courseID);
//			if(sc == null) {
//				System.out.println("Return null.");
//			} else {
//				System.out.println("course " + sc.getCourseID());
//				System.out.println("student " + sc.getStudentID());
//				System.out.println("Date " + sc.getEnrollDate());
//			}
			
//			StudentDB sdb = new StudentDB();
//			ArrayList<Student> sList = sdb.retrieveStudent("student_email", "Test Email");
//			Iterator<Student> si = sList.iterator();
//			while(si.hasNext()) {
//				Student s = si.next();
//				System.out.println(s.getStudentName());
//			}
			
//			Student s = new Student();
//			s.setStudentName("Test Name");
//			s.setStudentEmail("Test Email");
//			s.setStudentPassword("123345");
//			s.setStudentPhone("12345");
//			s.setStudentPhoto("Test Photo");
//			s.setStudentHome("My Home");
//			s.setStudentStreet("My Street");
//			s.setStudentTownship("My Town");
//			s.setStudentCity("My City");
//			
//			StudentDB sdb = new StudentDB();
//			sdb.createStudent(s);
			
//			Lecture l = new Lecture();
//			LectureDB ldb = new LectureDB();
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
			
			this.setHeader("studentPlainHeader");
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
