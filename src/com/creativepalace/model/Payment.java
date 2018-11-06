package com.creativepalace.model;

import java.math.BigDecimal;

public class Payment {
	private Long paymentID;
	private BigDecimal paymentAmount;
	private String paymentDate;
	private Long staffID;
	private Long studentCourseID;

	public Long getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(Long paymentID) {
		this.paymentID = paymentID;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Long getStaffID() {
		return staffID;
	}

	public void setStaffID(Long staffID) {
		this.staffID = staffID;
	}

	public Long getStudentCourseID() {
		return studentCourseID;
	}

	public void setStudentCourseID(Long studentCourseID) {
		this.studentCourseID = studentCourseID;
	}

}
