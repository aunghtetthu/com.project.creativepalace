package com.creativepalace.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.creativepalace.model.Lecture;

public class LectureDB {
	public void createLecture(Lecture l) {
		String sql = "INSERT INTO lecture (lecture_title, lecture_video, lecture_description, lecture_pdf, course_id) VALUES (?, ?, ?, ?, ?)";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, l.getLectureTitle());
			stmt.setString(2, l.getLectureVideo());
			stmt.setString(3, l.getLectureDescription());
			stmt.setString(4, l.getLecturePdf());
			stmt.setLong(5, l.getCourseID());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DBConnection.closeConnection(conn);
	}
	
	public void updateLecture(Lecture l) {
		String sql = "UPDATE lecture SET lecture_description=? WHERE lecture_id=?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, l.getLectureDescription());
			stmt.setLong(2, l.getLectureID());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
	}

	public ArrayList<Lecture> retrieveLecture(Long courseID) {
		ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
		String sql = "SELECT * FROM lecture WHERE course_id=?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, courseID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Lecture l = new Lecture();
				l.setLectureID(rs.getLong(1));
				l.setLectureTitle(rs.getString(2));
				l.setLectureVideo(rs.getString(3));
				l.setLectureDescription(rs.getString(4));
				l.setLecturePdf(rs.getString(5));
				l.setCourseID(rs.getLong(6));
				lectureList.add(l);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.closeConnection(conn);
//		return lectureList == null || lectureList.isEmpty() ? null : lectureList;
		return lectureList;
	}

	public Lecture getLectureByTitle(String title, Long courseID) {
		Lecture l = new Lecture();
		String sql = "SELECT * FROM lecture WHERE lecture_title=? AND course_id=?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, title);
			stmt.setLong(2, courseID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				l.setLectureID(rs.getLong(1));
				l.setLectureTitle(rs.getString(2));
				l.setLectureVideo(rs.getString(3));
				l.setLectureDescription(rs.getString(4));
				l.setLecturePdf(rs.getString(5));
				l.setCourseID(rs.getLong(6));
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.closeConnection(conn);
		return l;
	}
	
	public Lecture getLectureByID(Long lectureID) {
		Lecture l = new Lecture();
		String sql = "SELECT * FROM lecture WHERE lecture_id=?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, lectureID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				l.setLectureID(rs.getLong(1));
				l.setLectureTitle(rs.getString(2));
				l.setLectureVideo(rs.getString(3));
				l.setLectureDescription(rs.getString(4));
				l.setLecturePdf(rs.getString(5));
				l.setCourseID(rs.getLong(6));
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.closeConnection(conn);
		return l;
	}
}
