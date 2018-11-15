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
		String sql = "INSERT INTO student_course (course_id, student_id, exam_mark, course_access, student_type) VALUES (?, ?, ?, ?)";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, courseID);
			stmt.setLong(2, studentID);
			stmt.setInt(3, 0);
			stmt.setString(4, "pending");
			stmt.setString(5, "fresher");
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
				sc.setStudentType(rs.getString(7));
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
	
	public void deleteEnroll(Long studentCourseID) {
		String sql = "DELETE FROM student_course WHERE studentcourse_id = ?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, studentCourseID);
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
	}
}
