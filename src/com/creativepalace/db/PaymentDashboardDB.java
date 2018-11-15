package com.creativepalace.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.creativepalace.model.PaymentDashboard;

public class PaymentDashboardDB {
	public ArrayList<PaymentDashboard> getStudentPayment(Long studentID) {
		ArrayList<PaymentDashboard> pdList = new ArrayList<PaymentDashboard>();
		String sql = "SELECT p.payment_amount, p.payment_date, c.course_id, c.course_name, sc.enroll_date FROM payment p, course c, student_course sc, student s WHERE p.studentcourse_id = sc.studentcourse_id AND c.course_id = sc.course_id AND sc.student_id = s.student_id AND s.student_id =  ?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, studentID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				PaymentDashboard pd = new PaymentDashboard();
				pd.setAmount(rs.getBigDecimal(1));
				pd.setDate(rs.getString(2));
				pd.setCourseID(rs.getLong(3));
				pd.setCourseName(rs.getString(4));
				pd.setEnrollDate(rs.getString(5));
				pdList.add(pd);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
		return pdList;
	}
}
