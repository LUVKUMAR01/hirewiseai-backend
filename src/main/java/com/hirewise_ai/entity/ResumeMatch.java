package com.hirewise_ai.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name = "resume_matches")
public class ResumeMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int matchScore;

    @Column(columnDefinition = "TEXT")
    private String missingSkills;

    @Column(columnDefinition = "TEXT")
    private String suggestions;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public ResumeMatch() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(int matchScore) {
        this.matchScore = matchScore;
    }

    public String getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(String missingSkills) {
        this.missingSkills = missingSkills;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }
}