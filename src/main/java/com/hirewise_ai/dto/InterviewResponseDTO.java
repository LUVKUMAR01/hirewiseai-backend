package com.hirewise_ai.dto;

public class InterviewResponseDTO {

    private String questions;

    public InterviewResponseDTO() {
    }

    public InterviewResponseDTO(String questions) {
        this.questions = questions;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }
}