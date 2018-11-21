package com.creativepalace.model;

public class FAQ {
	private Long faqID;
	private String question;
	private String answer;
	private Long staffID;

	public Long getFaqID() {
		return faqID;
	}

	public void setFaqID(Long faqID) {
		this.faqID = faqID;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Long getStaffID() {
		return staffID;
	}

	public void setStaffID(Long staffID) {
		this.staffID = staffID;
	}
}
