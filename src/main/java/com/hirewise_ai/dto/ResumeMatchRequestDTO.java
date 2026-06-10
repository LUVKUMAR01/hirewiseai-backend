package com.hirewise_ai.dto;

public class ResumeMatchRequestDTO {

    private int resumeId;

    private String jobDescription;

    public ResumeMatchRequestDTO() {
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
}