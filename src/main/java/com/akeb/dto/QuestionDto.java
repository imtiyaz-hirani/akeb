package com.akeb.dto;

import java.util.List;

public class QuestionDto {
	private Long webinarID;
	private String email;
	private List<QuestionBean> questions;

	public static class QuestionBean {
		private String qtext;
		private String ans;

		public String getQtext() {
			return qtext;
		}

		public void setQtext(String qtext) {
			this.qtext = qtext;
		}

		public String getAns() {
			return ans;
		}

		public void setAns(String ans) {
			this.ans = ans;
		}

	}

	public Long getWebinarID() {
		return webinarID;
	}

	public void setWebinarID(Long webinarID) {
		this.webinarID = webinarID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<QuestionBean> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionBean> questions) {
		this.questions = questions;
	}

}
