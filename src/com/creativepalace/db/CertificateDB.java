package com.creativepalace.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.creativepalace.model.Certificate;
import com.creativepalace.model.IssueCertificate;

public class CertificateDB {
	public void createCertificate(Certificate certificate) {
		String sql = "INSERT INTO certificate (certificate_pdf, issue_date, studentcourse_id) VALUES (?,?,?)";
		String updateSql = "UPDATE student_course SET student_type = ? WHERE studentcourse_id = ?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, certificate.getCertificatePDF());

			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String issueDate = dateFormat.format(date);

			stmt.setString(2, issueDate);
			stmt.setLong(3, certificate.getStudentCourseID());

			stmt.executeUpdate();
			stmt.close();

			PreparedStatement updateStmt = conn.prepareStatement(updateSql);
			updateStmt.setString(1, "certified");
			updateStmt.setLong(2, certificate.getStudentCourseID());
			updateStmt.executeUpdate();
			updateStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnection.closeConnection(conn);
	}

	public ArrayList<IssueCertificate> getCandidates() {
		ArrayList<IssueCertificate> icList = new ArrayList<IssueCertificate>();
		String sql = "SELECT s.student_name, s.student_email, s.student_phone, c.course_id, c.course_name, sc.exam_mark, sc.studentcourse_id FROM course c, student_course sc, student s WHERE c.course_id = sc.course_id AND s.student_id = sc.student_id AND sc.student_type = ?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "candidate");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				IssueCertificate ic = new IssueCertificate();
				ic.setStudentName(rs.getString(1));
				ic.setStudentEmal(rs.getString(2));
				ic.setStudentPhone(rs.getString(3));
				ic.setCourseID(rs.getLong(4));
				ic.setCourseName(rs.getString(5));
				ic.setStudentMark(rs.getString(6));
				ic.setStudentCourseID(rs.getLong(7));
				
				icList.add(ic);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
		return icList;
	}
	
	public ArrayList<IssueCertificate> getCandidatesByEmail(String email) {
		ArrayList<IssueCertificate> icList = new ArrayList<IssueCertificate>();
		String sql = "SELECT s.student_name, s.student_email, s.student_phone, c.course_id, c.course_name, sc.exam_mark, sc.studentcourse_id FROM course c, student_course sc, student s WHERE c.course_id = sc.course_id AND s.student_id = sc.student_id AND sc.student_type = ? AND s.student_email = ?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "candidate");
			stmt.setString(2, email);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				IssueCertificate ic = new IssueCertificate();
				ic.setStudentName(rs.getString(1));
				ic.setStudentEmal(rs.getString(2));
				ic.setStudentPhone(rs.getString(3));
				ic.setCourseID(rs.getLong(4));
				ic.setCourseName(rs.getString(5));
				ic.setStudentMark(rs.getString(6));
				ic.setStudentCourseID(rs.getLong(7));
				
				icList.add(ic);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
		return icList;
	}
	
	public ArrayList<IssueCertificate> getCertifiedStudents() {
		ArrayList<IssueCertificate> icList = new ArrayList<IssueCertificate>();
		String sql = "SELECT s.student_name, s.student_email, s.student_phone, c.course_id, c.course_name, sc.exam_mark, ce.issue_date, ce.certificate_pdf FROM certificate ce, student_course sc, course c, student s WHERE ce.studentcourse_id = sc.studentcourse_id AND c.course_id = sc.course_id AND s.student_id = sc.student_id";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				IssueCertificate ic = new IssueCertificate();
				ic.setStudentName(rs.getString(1));
				ic.setStudentEmal(rs.getString(2));
				ic.setStudentPhone(rs.getString(3));
				ic.setCourseID(rs.getLong(4));
				ic.setCourseName(rs.getString(5));
				ic.setStudentMark(rs.getString(6));
				ic.setIssueDate(rs.getString(7));
				ic.setCertificatePDF(rs.getString(8));
				
				icList.add(ic);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
		return icList;
	}
	
	public ArrayList<IssueCertificate> getCertifiedStudentByEmail(String email) {
		ArrayList<IssueCertificate> icList = new ArrayList<IssueCertificate>();
		String sql = "SELECT s.student_name, s.student_email, s.student_phone, c.course_id, c.course_name, sc.exam_mark, ce.issue_date, ce.certificate_pdf FROM certificate ce, student_course sc, course c, student s WHERE ce.studentcourse_id = sc.studentcourse_id AND c.course_id = sc.course_id AND s.student_id = sc.student_id AND s.student_email = ?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				IssueCertificate ic = new IssueCertificate();
				ic.setStudentName(rs.getString(1));
				ic.setStudentEmal(rs.getString(2));
				ic.setStudentPhone(rs.getString(3));
				ic.setCourseID(rs.getLong(4));
				ic.setCourseName(rs.getString(5));
				ic.setStudentMark(rs.getString(6));
				ic.setIssueDate(rs.getString(7));
				ic.setCertificatePDF(rs.getString(8));
				
				icList.add(ic);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
		return icList;
	}
}
