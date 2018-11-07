package com.creativepalace.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.creativepalace.model.Course;
import com.creativepalace.model.Enrollment;
import com.creativepalace.model.Student;
import com.creativepalace.model.StudentCourse;

public class StudentCourseDB {
	public void enrollCourse(Long studentID, Long courseID) {
		String sql = "INSERT INTO student_course (course_id, student_id, exam_mark, course_access) VALUES (?, ?, ?, ?)";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, courseID);
			stmt.setLong(2, studentID);
			stmt.setInt(3, 0);
			stmt.setString(4, "pending");
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.closeConnection(conn);
	}

	public StudentCourse getEnroll(Long studentID, Long courseID) {
		StudentCourse sc = null;
		String sql = "SELECT * FROM student_course WHERE student_id=? AND course_id=?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, studentID);
			stmt.setLong(2, courseID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				sc = new StudentCourse();
				sc.setStudentCourseID(rs.getLong(1));
				sc.setCourseID(rs.getLong(2));
				sc.setStudentID(rs.getLong(3));
				sc.setEnrollDate(rs.getString(4));
				sc.setCourseAccess(rs.getString(5));
				sc.setExamMark(rs.getInt(6));
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnection.closeConnection(conn);
		return sc;
	}
	
	public ArrayList<Enrollment> getNewEnrollment() {
		ArrayList<Enrollment> eList = new ArrayList<Enrollment>();
		String sql = "SELECT s.student_name, s.student_email, s.student_phone, c.course_id, c.course_name, c.course_price, sc.studentcourse_id FROM student s, course c, student_course sc WHERE sc.student_id = s.student_id AND sc.course_id = c.course_id AND sc.course_access = ?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "pending");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
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
		String sql = "SELECT s.student_name, s.student_email, s.student_phone, c.course_id, c.course_name, c.course_price, sc.studentcourse_id FROM student s, course c, student_course sc WHERE sc.student_id = s.student_id AND sc.course_id = c.course_id AND sc.course_access = ?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "confirmed");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
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
	
	public ArrayList<Enrollment> searchEnrollment(String courseAccess, String studentEmail, Long courseID) {
		ArrayList<Enrollment> eList = new ArrayList<Enrollment>();
		String sql = "SELECT s.student_name, s.student_email, s.student_phone, c.course_id, c.course_name, c.course_price, sc.studentcourse_id FROM student s, course c, student_course sc WHERE sc.student_id = s.student_id AND sc.course_id = c.course_id AND sc.course_access = ? AND s.student_email = ? AND c.course_id = ?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, courseAccess);
			stmt.setString(2, studentEmail);
			stmt.setLong(3, courseID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
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
}
