package com.creativepalace.model;

public class IssueCertificate {
	private String studentName;
	private String studentEmal;
	private String studentPhone;
	private Long courseID;
	private String courseName;
	private String studentMark;
	private Long studentCourseID;
	private String certificatePDF;
	private String issueDate;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmal() {
		return studentEmal;
	}

	public void setStudentEmal(String studentEmal) {
		this.studentEmal = studentEmal;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public Long getCourseID() {
		return courseID;
	}

	public void setCourseID(Long courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStudentMark() {
		return studentMark;
	}

	public void setStudentMark(String studentMark) {
		this.studentMark = studentMark;
	}

	public Long getStudentCourseID() {
		return studentCourseID;
	}

	public void setStudentCourseID(Long studentCourseID) {
		this.studentCourseID = studentCourseID;
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
}
