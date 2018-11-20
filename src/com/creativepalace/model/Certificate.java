package com.creativepalace.model;

public class Certificate {
	private Long certificateID;
	private String certificatePDF;
	private String issueDate;
	private Long studentCourseID;

	public Long getCertificateID() {
		return certificateID;
	}

	public void setCertificateID(Long certificateID) {
		this.certificateID = certificateID;
	}

	public String getCertificatePDF() {
		return certificatePDF;
	}

	public void setCertificatePDF(String certificatePDF) {
		this.certificatePDF = certificatePDF;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public Long getStudentCourseID() {
		return studentCourseID;
	}

	public void setStudentCourseID(Long studentCourseID) {
		this.studentCourseID = studentCourseID;
	}
}
