package com.creativepalace.model;

public class Lecture {
	private Long lectureID;
	private String lectureTitle;
	private String lectureVideo;
	private String lectureDescription;
	private String lecturePdf;
	private Long courseID;

	public Long getLectureID() {
		return lectureID;
	}

	public void setLectureID(Long lectureID) {
		this.lectureID = lectureID;
	}

	public String getLectureTitle() {
		return lectureTitle;
	}

	public void setLectureTitle(String lectureTitle) {
		this.lectureTitle = lectureTitle;
	}

	public String getLectureVideo() {
		return lectureVideo;
	}

	public void setLectureVideo(String lectureVideo) {
		this.lectureVideo = lectureVideo;
	}

	public String getLectureDescription() {
		return lectureDescription;
	}

	public void setLectureDescription(String lectureDescription) {
		this.lectureDescription = lectureDescription;
	}

	public String getLecturePdf() {
		return lecturePdf;
	}

	public void setLecturePdf(String lecturePdf) {
		this.lecturePdf = lecturePdf;
	}

	public Long getCourseID() {
		return courseID;
	}

	public void setCourseID(Long courseID) {
		this.courseID = courseID;
	}

}
