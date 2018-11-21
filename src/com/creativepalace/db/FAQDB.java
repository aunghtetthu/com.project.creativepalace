package com.creativepalace.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.creativepalace.model.FAQ;

public class FAQDB {
	public void addFAQ(FAQ faq) {
		String sql = "INSERT INTO faq (question, answer, staff_id) VALUES (?,?,?)";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, faq.getQuestion());
			stmt.setString(2, faq.getAnswer());
			stmt.setLong(3, faq.getStaffID());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
	}
	
	public ArrayList<FAQ> retrieveFAQ() {
		ArrayList<FAQ> faqList = new ArrayList<FAQ>();
		String sql = "SELECT * FROM faq";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				FAQ faq = new FAQ();
				faq.setFaqID(rs.getLong(1));
				faq.setQuestion(rs.getString(2));
				faq.setAnswer(rs.getString(3));
				faq.setStaffID(rs.getLong(4));
				
				faqList.add(faq);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
		return faqList;
	}
	
	public void deleteFAQ(Long faqID) {
		String sql = "DELETE FROM faq WHERE faq_id = ?";
		Connection conn = DBConnection.createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, faqID);
			stmt.executeUpdate();
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection(conn);
	}
}
