package com.creativepalace.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.creativepalace.model.Student;

public class StudentDB {
	public void createStudent(Student s) {
		String sql = "INSERT INTO student (student_name, student_email, student_password, student_phone, student_photo, student_home, student_street, student_township, student_city) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, s.getStudentName());
			stmt.setString(2, s.getStudentEmail());
			stmt.setString(3, s.getStudentPassword());
			stmt.setString(4, s.getStudentPhone());
			stmt.setString(5, s.getStudentPhoto());
			stmt.setString(6, s.getStudentHome());
			stmt.setString(7, s.getStudentStreet());
			stmt.setString(8, s.getStudentTownship());
			stmt.setString(9, s.getStudentCity());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.closeConnection(conn);
	}
	
	public ArrayList<Student> retrieveStudent(String fieldName, String data) {
		String sql = "SELECT * FROM student WHERE " + fieldName + "=?";
		ArrayList<Student> studentList = new ArrayList<Student>();
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, data);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Student s = new Student();
				s.setStudentID(rs.getLong(1));
				s.setStudentName(rs.getString(2));
				s.setStudentEmail(rs.getString(3));
				s.setStudentPassword(rs.getString(4));
				s.setStudentPhone(rs.getString(5));
				s.setStudentPhoto(rs.getString(6));
				s.setStudentHome(rs.getString(7));
				s.setStudentStreet(rs.getString(8));
				s.setStudentTownship(rs.getString(9));
				s.setStudentCity(rs.getString(10));
				studentList.add(s);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
		return studentList == null || studentList.isEmpty() ? null : studentList;
	}
	
	public ArrayList<Student> retrieveStudent() {
		String sql = "SELECT * FROM student";
		ArrayList<Student> studentList = new ArrayList<Student>();
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Student s = new Student();
				s.setStudentID(rs.getLong(1));
				s.setStudentName(rs.getString(2));
				s.setStudentEmail(rs.getString(3));
				s.setStudentPassword(rs.getString(4));
				s.setStudentPhone(rs.getString(5));
				s.setStudentPhoto(rs.getString(6));
				s.setStudentHome(rs.getString(7));
				s.setStudentStreet(rs.getString(8));
				s.setStudentTownship(rs.getString(9));
				s.setStudentCity(rs.getString(10));
				studentList.add(s);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
		return studentList;
	}
	
	public Student getStudentByEmail(String email) {
		Student s = new Student();
		String sql = "SELECT * FROM student WHERE student_email=?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				s.setStudentID(rs.getLong(1));
				s.setStudentName(rs.getString(2));
				s.setStudentEmail(rs.getString(3));
				s.setStudentPassword(rs.getString(4));
				s.setStudentPhone(rs.getString(5));
				s.setStudentPhoto(rs.getString(6));
				s.setStudentHome(rs.getString(7));
				s.setStudentStreet(rs.getString(8));
				s.setStudentTownship(rs.getString(9));
				s.setStudentCity(rs.getString(10));
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
		return s;
	}
}
