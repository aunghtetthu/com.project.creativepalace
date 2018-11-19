package com.creativepalace.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.creativepalace.model.ExamQuestion;

public class ExamQuestionDB {
	public ArrayList<ExamQuestion> retrieveExamQuestion(Long courseID) {
		ArrayList<ExamQuestion> eqList = new ArrayList<ExamQuestion>();
		String sql = "SELECT * FROM exam_question WHERE course_id=? ORDER BY question_number";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, courseID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ExamQuestion eq = new ExamQuestion();
				eq.setExamQuestionID(rs.getLong(1));
				eq.setQuestion(rs.getString(2));
				eq.setQuestionNumber(rs.getInt(3));
				eq.setChoice1(rs.getString(4));
				eq.setChoice2(rs.getString(5));
				eq.setChoice3(rs.getString(6));
				eq.setChoice4(rs.getString(7));
				eq.setChoice5(rs.getString(8));
				eq.setAnswer(rs.getString(9));
				eq.setCourseID(rs.getLong(10));
				eq.setMark(rs.getInt(11));
				eqList.add(eq);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.closeConnection(conn);
		return eqList;
	}
	
	public ExamQuestion getExamQuestion(Long examQuestionID) {
		ExamQuestion eq = new ExamQuestion();
		String sql = "SELECT * FROM exam_question WHERE examquestion_id = ?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, examQuestionID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				eq.setExamQuestionID(rs.getLong(1));
				eq.setQuestion(rs.getString(2));
				eq.setQuestionNumber(rs.getInt(3));
				eq.setChoice1(rs.getString(4));
				eq.setChoice2(rs.getString(5));
				eq.setChoice3(rs.getString(6));
				eq.setChoice4(rs.getString(7));
				eq.setChoice5(rs.getString(8));
				eq.setAnswer(rs.getString(9));
				eq.setCourseID(rs.getLong(10));
				eq.setMark(rs.getInt(11));
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
		return eq;
	}
	
	public void addExamQuestion(ExamQuestion examQuestion) {
		String sql = "INSERT INTO exam_question(question, question_number, choice1, choice2, choice3, choice4, choice5, answer, course_id, mark) VALUES (?,?,?,?,?,?,?,?,?,?)";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, examQuestion.getQuestion());
			stmt.setInt(2, examQuestion.getQuestionNumber());
			stmt.setString(3, examQuestion.getChoice1());
			stmt.setString(4, examQuestion.getChoice2());
			stmt.setString(5, examQuestion.getChoice3());
			stmt.setString(6, examQuestion.getChoice4());
			stmt.setString(7, examQuestion.getChoice5());
			stmt.setString(8, examQuestion.getAnswer());
			stmt.setLong(9, examQuestion.getCourseID());
			stmt.setInt(10, examQuestion.getMark());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnection.closeConnection(conn);
	}
	
	public void editExamQuestion(ExamQuestion examQuestion) {
		String sql = "UPDATE exam_question SET question = ?, question_number = ?, choice1 = ? , choice2 = ?, choice3 = ?, choice4 = ?,  choice5 = ?, answer = ?, mark = ? WHERE examquestion_id = ?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, examQuestion.getQuestion());
			stmt.setInt(2, examQuestion.getQuestionNumber());
			stmt.setString(3, examQuestion.getChoice1());
			stmt.setString(4, examQuestion.getChoice2());
			stmt.setString(5, examQuestion.getChoice3());
			stmt.setString(6, examQuestion.getChoice4());
			stmt.setString(7, examQuestion.getChoice5());
			stmt.setString(8, examQuestion.getAnswer());
			stmt.setInt(9, examQuestion.getMark());
			stmt.setLong(10, examQuestion.getExamQuestionID());
			stmt.executeUpdate();
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
	}
	
	public void deleteExamQuestion(Long examQuestionID) {
		String sql = "DELETE FROM exam_question WHERE examquestion_id = ?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, examQuestionID);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
	}
}
