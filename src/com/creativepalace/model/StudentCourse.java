package com.creativepalace.model;

public class StudentCourse {
	private Long studentCourseID;
	private Long courseID;
	private Long studentID;
	private String enrollDate;
	private String courseAccess;
	private int examMark;
	private String studentType;

	public Long getStudentCourseID() {
		return studentCourseID;
	}

	public void setStudentCourseID(Long studentCourseID) {
		this.studentCourseID = studentCourseID;
	}

	public Long getCourseID() {
		return courseID;
	}

	public void setCourseID(Long courseID) {
		this.courseID = courseID;
	}

	public Long getStudentID() {
		return studentID;
	}

	public void setStudentID(Long studentID) {
		this.studentID = studentID;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getExamMark() {
		return examMark;
	}

	public void setExamMark(int examMark) {
		this.examMark = examMark;
	}

	public String getCourseAccess() {
		return courseAccess;
	}

	public void setCourseAccess(String courseAccess) {
		this.courseAccess = courseAccess;
	}

	public String getStudentType() {
		return studentType;
	}

	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}
}
