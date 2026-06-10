package com.hirewise_ai.dto;

public class AnalysisResponseDTO {

    private int atsScore;
    private String suggestions;

    public AnalysisResponseDTO() {
    }

    public int getAtsScore() {
        return atsScore;
    }

    public void setAtsScore(int atsScore) {
        this.atsScore = atsScore;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }
}