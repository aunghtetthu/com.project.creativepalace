package com.creativepalace.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.creativepalace.model.Course;

public class CourseDB {
	public void createCourse(Course c) {
		String sql = "INSERT INTO course (course_name, course_duration, course_info, course_syllabus, course_price, course_category, course_coverphoto, course_status, staff_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getCourseName());
			stmt.setString(2, c.getCourseDuration());
			stmt.setString(3, c.getCourseInfo());
			stmt.setString(4, c.getCourseSyllabus());
			stmt.setBigDecimal(5, c.getCoursePrice());
			stmt.setString(6, c.getCourseCategory());
			stmt.setString(7, c.getCourseCoverPhoto());
			stmt.setString(8, "active");
			stmt.setLong(9, c.getStaffID());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.closeConnection(conn);
	}
	
	public Course getCourseByID(Long id) {
		Course c = new Course();
		String sql = "SELECT * FROM course WHERE course_id=?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				c.setCourseID(rs.getLong(1));
				c.setCourseName(rs.getString(2));
				c.setCourseDuration(rs.getString(3));
				c.setCourseInfo(rs.getString(4));
				c.setCourseSyllabus(rs.getString(5));
				c.setCoursePrice(rs.getBigDecimal(6));
				c.setCourseCategory(rs.getString(7));
				c.setCourseCoverPhoto(rs.getString(8));
				c.setCourseStatus(rs.getString(9));
				c.setStaffID((long)rs.getInt(10));
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
		return c;
	}
	
	public Course getCourseByName(String courseName) {
		Course c = new Course();
		String sql = "SELECT * FROM course WHERE course_name=? AND course_status='active'";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, courseName);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				c.setCourseID(rs.getLong(1));
				c.setCourseName(rs.getString(2));
				c.setCourseDuration(rs.getString(3));
				c.setCourseInfo(rs.getString(4));
				c.setCourseSyllabus(rs.getString(5));
				c.setCoursePrice(rs.getBigDecimal(6));
				c.setCourseCategory(rs.getString(7));
				c.setCourseCoverPhoto(rs.getString(8));
				c.setCourseStatus(rs.getString(9));
				c.setStaffID((long)rs.getInt(10));
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
		return c;
	}
	
	public ArrayList<Course> retrieveCourse(String courseStatus) {
		ArrayList<Course> courseList = new ArrayList<Course>();
		String sql = "SELECT * FROM course WHERE course_status=?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, courseStatus);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Course c = new Course();
				c.setCourseID(rs.getLong(1));
				c.setCourseName(rs.getString(2));
				c.setCourseDuration(rs.getString(3));
				c.setCourseInfo(rs.getString(4));
				c.setCourseSyllabus(rs.getString(5));
				c.setCoursePrice(rs.getBigDecimal(6));
				c.setCourseCategory(rs.getString(7));
				c.setCourseCoverPhoto(rs.getString(8));
				c.setCourseStatus(rs.getString(9));
				c.setStaffID((long)rs.getInt(10));
				courseList.add(c);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
//		return courseList==null || courseList.isEmpty() ? null : courseList;
		return courseList;
	}
	
	public ArrayList<Course> retrieveCourseByData(String fieldName, String data, String courseStatus) {
		ArrayList<Course> courseList = new ArrayList<Course>();
		String sql = "SELECT * FROM course WHERE " + fieldName + "=? AND course_status=?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, data);
			stmt.setString(2, courseStatus);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Course c = new Course();
				c.setCourseID(rs.getLong(1));
				c.setCourseName(rs.getString(2));
				c.setCourseDuration(rs.getString(3));
				c.setCourseInfo(rs.getString(4));
				c.setCourseSyllabus(rs.getString(5));
				c.setCoursePrice(rs.getBigDecimal(6));
				c.setCourseCategory(rs.getString(7));
				c.setCourseCoverPhoto(rs.getString(8));
				c.setCourseStatus(rs.getString(9));
				c.setStaffID((long)rs.getInt(10));
				courseList.add(c);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
//		return courseList==null || courseList.isEmpty() ? null : courseList;
		return courseList;
	}
	
	public ArrayList<Course> searchCourse(String fieldName, String searchKey) {
		ArrayList<Course> courseList = new ArrayList<Course>();
		String sql = "SELECT * FROM course WHERE " + fieldName + "=?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, searchKey);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Course c = new Course();
				c.setCourseID(rs.getLong(1));
				c.setCourseName(rs.getString(2));
				c.setCourseDuration(rs.getString(3));
				c.setCourseInfo(rs.getString(4));
				c.setCourseSyllabus(rs.getString(5));
				c.setCoursePrice(rs.getBigDecimal(6));
				c.setCourseCategory(rs.getString(7));
				c.setCourseCoverPhoto(rs.getString(8));
				c.setCourseStatus(rs.getString(9));
				c.setStaffID((long)rs.getInt(10));
				courseList.add(c);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
//		return courseList==null || courseList.isEmpty() ? null : courseList;
		return courseList;
	}
}
