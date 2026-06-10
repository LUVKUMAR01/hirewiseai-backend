package com.hirewise_ai.entity;

import jakarta.persistence.*;

@Entity
@Table(name="mock_interviews")
public class MockInterview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition="TEXT")
    private String question;

    @Column(columnDefinition="TEXT")
    private String answer;

    @Column(columnDefinition="TEXT")
    private String feedback;

    private int score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public MockInterview(int id, String question, String answer, String feedback, int score) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.feedback = feedback;
		this.score = score;
	}

	public MockInterview() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}