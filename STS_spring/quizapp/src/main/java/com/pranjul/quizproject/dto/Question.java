package com.pranjul.quizproject.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
	
	
	

	/*
	 * Constructor Initialization
	 * public Question(Integer id, String questionTitle, String option1, String
	 * option2, String option3, String option4, String category, String
	 * difficultylevel, String rightAnswer) { super(); this.id = id;
	 * this.questionTitle = questionTitle; this.option1 = option1; this.option2 =
	 * option2; this.option3 = option3; this.option4 = option4; this.category =
	 * category; this.difficultylevel = difficultylevel; this.rightAnswer =
	 * rightAnswer; }
	 */

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionTitle=" + questionTitle + ", option1=" + option1 + ", option2="
				+ option2 + ", option3=" + option3 + ", option4=" + option4 + ", category=" + category
				+ ", difficultylevel=" + difficultylevel + ", rightanswer=" + rightAnswer + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDifficultylevel() {
		return difficultylevel;
	}

	public void setDifficultylevel(String difficultylevel) {
		this.difficultylevel = difficultylevel;
	}

	public String getRightanswer() {
		return rightAnswer;
	}

	public void setRightanswer(String rightanswer) {
		this.rightAnswer = rightanswer;
	}

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String category;
	private String difficultylevel;
	private String rightAnswer;

}
