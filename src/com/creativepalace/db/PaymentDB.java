package com.creativepalace.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.creativepalace.model.Payment;

public class PaymentDB {
	
	public void recordPayment(Payment p) {
		String sql = "INSERT INTO payment (payment_amount, staff_id, studentcourse_id) VALUES (?, ?, ?)";
		String scSql = "UPDATE student_course SET course_access=? WHERE studentcourse_id=?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setBigDecimal(1, p.getPaymentAmount());
			stmt.setLong(2, p.getStaffID());
			stmt.setLong(3, p.getStudentCourseID());
			stmt.executeUpdate();						
			stmt.close();
			
			PreparedStatement scStmt = conn.prepareStatement(scSql);
			scStmt.setString(1, "confirmed");
			scStmt.setLong(2, p.getStudentCourseID());
			scStmt.executeUpdate();
			scStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.closeConnection(conn);
	}
	
	public Payment checkPayment(Long courseID, Long studentID) {
		Payment p = new Payment();
		String sql = "SELECT p.* FROM payment p, student_course sc, course c, student s WHERE p.studentcourse_id = sc.studentcourse_id AND sc.course_id = c.course_id AND c.course_id = ? AND sc.student_id = s.student_id AND s.student_id = ?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, courseID);
			stmt.setLong(2, studentID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				p.setPaymentID(rs.getLong(1));
				p.setPaymentAmount(rs.getBigDecimal(2));
				p.setPaymentDate(rs.getString(3));
				p.setStaffID(rs.getLong(4));
				p.setStudentCourseID(rs.getLong(5));
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
		return p;
	}
	
	public void cancelPayment(Long studentCourseID) {
		String sql = "DELETE FROM payment WHERE studentcourse_id = ?";
		String scSql = "UPDATE student_course SET course_access=? WHERE studentcourse_id=?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, studentCourseID);
			stmt.executeUpdate();
			stmt.close();
			
			PreparedStatement scStmt = conn.prepareStatement(scSql);
			scStmt.setString(1, "pending");
			scStmt.setLong(2, studentCourseID);
			scStmt.executeUpdate();
			scStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
	}
}
