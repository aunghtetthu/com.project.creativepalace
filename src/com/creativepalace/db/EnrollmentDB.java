package com.creativepalace.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.creativepalace.model.Enrollment;

public class EnrollmentDB {

	public ArrayList<Enrollment> getNewEnrollment() {
		ArrayList<Enrollment> eList = new ArrayList<Enrollment>();
		String sql = "SELECT s.student_name, s.student_email, s.student_phone, c.course_id, c.course_name, c.course_price, sc.studentcourse_id FROM student s, course c, student_course sc WHERE sc.student_id = s.student_id AND sc.course_id = c.course_id AND sc.course_access = ?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "pending");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Enrollment enrollment = new Enrollment();
				enrollment.setStudentName(rs.getString(1));
				enrollment.setStudentEmail(rs.getString(2));
				enrollment.setStudentPhone(rs.getString(3));
				enrollment.setCourseID(rs.getLong(4));
				enrollment.setCourseName(rs.getString(5));
				enrollment.setCoursePrice(rs.getBigDecimal(6));
				enrollment.setStudentCourseID(rs.getLong(7));

				eList.add(enrollment);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnection.closeConnection(conn);
		return eList;
	}

	public ArrayList<Enrollment> getConfirmedEnrollment() {
		ArrayList<Enrollment> eList = new ArrayList<Enrollment>();
		String sql = "SELECT s.student_name, s.student_email, s.student_phone, c.course_id, c.course_name, c.course_price, sc.studentcourse_id, st.staff_id, st.staff_name  FROM student s, course c, student_course sc, payment p, staff st WHERE sc.student_id = s.student_id AND sc.course_id = c.course_id AND sc.studentcourse_id = p.studentcourse_id AND p.staff_id = st.staff_id AND sc.course_access = ?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "confirmed");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Enrollment enrollment = new Enrollment();
				enrollment.setStudentName(rs.getString(1));
				enrollment.setStudentEmail(rs.getString(2));
				enrollment.setStudentPhone(rs.getString(3));
				enrollment.setCourseID(rs.getLong(4));
				enrollment.setCourseName(rs.getString(5));
				enrollment.setCoursePrice(rs.getBigDecimal(6));
				enrollment.setStudentCourseID(rs.getLong(7));
				enrollment.setStaffID(rs.getLong(8));
				enrollment.setStaffName(rs.getString(9));

				eList.add(enrollment);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnection.closeConnection(conn);
		return eList;
	}

//	public ArrayList<Enrollment> searchEnrollment(String courseAccess, String studentEmail, Long courseID) {
//		ArrayList<Enrollment> eList = new ArrayList<Enrollment>();
//		String sql = "SELECT s.student_name, s.student_email, s.student_phone, c.course_id, c.course_name, c.course_price, sc.studentcourse_id FROM student s, course c, student_course sc WHERE sc.student_id = s.student_id AND sc.course_id = c.course_id AND sc.course_access = ? AND s.student_email = ? AND c.course_id = ?";
//		Connection conn = DBConnection.createConnection();
//		try {
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, courseAccess);
//			stmt.setString(2, studentEmail);
//			stmt.setLong(3, courseID);
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				Enrollment enrollment = new Enrollment();
//				enrollment.setStudentName(rs.getString(1));
//				enrollment.setStudentEmail(rs.getString(2));
//				enrollment.setStudentPhone(rs.getString(3));
//				enrollment.setCourseID(rs.getLong(4));
//				enrollment.setCourseName(rs.getString(5));
//				enrollment.setCoursePrice(rs.getBigDecimal(6));
//				enrollment.setStudentCourseID(rs.getLong(7));
//
//				eList.add(enrollment);
//			}
//
//			rs.close();
//			stmt.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		DBConnection.closeConnection(conn);
//		return eList;
//	}

	public ArrayList<Enrollment> searchEnrollment(String courseAccess, String studentEmail, Long courseID) {
		ArrayList<Enrollment> eList = new ArrayList<Enrollment>();
		String sql = null;
		if(courseAccess.equals("pending")) {
			sql = "SELECT s.student_name, s.student_email, s.student_phone, c.course_id, c.course_name, c.course_price, sc.studentcourse_id FROM student s, course c, student_course sc WHERE sc.student_id = s.student_id AND sc.course_id = c.course_id AND sc.course_access = ? AND s.student_email = ? AND c.course_id = ?";
		} else if(courseAccess.equals("confirmed")) {
			sql = "SELECT s.student_name, s.student_email, s.student_phone, c.course_id, c.course_name, c.course_price, sc.studentcourse_id, st.staff_id, st.staff_name  FROM student s, course c, student_course sc, payment p, staff st WHERE sc.student_id = s.student_id AND sc.course_id = c.course_id AND sc.studentcourse_id = p.studentcourse_id AND p.staff_id = st.staff_id AND sc.course_access = ? AND s.student_email = ? AND c.course_id = ?";
		}
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, courseAccess);
			stmt.setString(2, studentEmail);
			stmt.setLong(3, courseID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Enrollment enrollment = new Enrollment();
				enrollment.setStudentName(rs.getString(1));
				enrollment.setStudentEmail(rs.getString(2));
				enrollment.setStudentPhone(rs.getString(3));
				enrollment.setCourseID(rs.getLong(4));
				enrollment.setCourseName(rs.getString(5));
				enrollment.setCoursePrice(rs.getBigDecimal(6));
				enrollment.setStudentCourseID(rs.getLong(7));
				enrollment.setStaffID(rs.getLong(8));
				enrollment.setStaffName(rs.getString(9));

				eList.add(enrollment);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnection.closeConnection(conn);
		return eList;
	}
}
