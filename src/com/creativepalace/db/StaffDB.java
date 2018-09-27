package com.creativepalace.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.creativepalace.model.Staff;

public class StaffDB {
	public void createStaff(Staff s) {
		String sql = "INSERT INTO staff (staff_name, staff_email, staff_password, staff_role, staff_phone, staff_photo) VALUES (?, ?, ?, ?, ?, ?)";
		Connection c = DBConnection.createConnection();
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, s.getStaffName());
			stmt.setString(2, s.getStaffEmail());
			stmt.setString(3, s.getStaffPassword());
			stmt.setString(4, s.getStaffRole());
			stmt.setString(5, s.getStaffPhone());
			stmt.setString(6, s.getStaffPhoto());
			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DBConnection.closeConnection(c);
	}

	public ArrayList<Staff> retrieveStaff(String fieldName, String data) {
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		Connection c = DBConnection.createConnection();
		try {
			String sql = "SELECT * FROM staff WHERE " + fieldName + "=?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, data);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Staff s = new Staff();
				s.setStaffID(rs.getLong(1));
				s.setStaffName(rs.getString(2));
				s.setStaffEmail(rs.getString(3));
				s.setStaffPassword(rs.getString(4));
				s.setStaffRole(rs.getString(5));
				s.setStaffPhone(rs.getString(6));
				s.setStaffPhoto(rs.getString(7));
				staffList.add(s);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DBConnection.closeConnection(c);
		return staffList == null || staffList.isEmpty() ? null : staffList;
	}

	public Staff getStaffByEmail(String email) {
		Staff s = new Staff();
		String sql = "SELECT * FROM staff WHERE staff_email=?";
		Connection c = DBConnection.createConnection();
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				s.setStaffID(rs.getLong(1));
				s.setStaffName(rs.getString(2));
				s.setStaffEmail(rs.getString(3));
				s.setStaffPassword(rs.getString(4));
				s.setStaffRole(rs.getString(5));
				s.setStaffPhone(rs.getString(6));
				s.setStaffPhoto(rs.getString(7));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DBConnection.closeConnection(c);
		return s;
	}
	
	public Staff getStaffById(Long staffID) {
		Staff s = new Staff();
		String sql = "SELECT * FROM staff WHERE staff_id=?";
		Connection c = DBConnection.createConnection();
		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setLong(1, staffID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				s.setStaffID(rs.getLong(1));
				s.setStaffName(rs.getString(2));
				s.setStaffEmail(rs.getString(3));
				s.setStaffPassword(rs.getString(4));
				s.setStaffRole(rs.getString(5));
				s.setStaffPhone(rs.getString(6));
				s.setStaffPhoto(rs.getString(7));
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DBConnection.closeConnection(c);
		return s;
	}
}
