package com.hirewise_ai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity(name="analysis_reports")
public class AnalysisReport {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
Integer atsScore;

@Lob
@Column(columnDefinition = "LONGTEXT")
String suggestions;


@ManyToOne
@JoinColumn(name = "resume_id")
private Resume resume;


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public Integer getAtsScore() {
	return atsScore;
}


public void setAtsScore(Integer atsScore) {
	this.atsScore = atsScore;
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


public AnalysisReport(int id, Integer atsScore, String suggestions, Resume resume) {
	super();
	this.id = id;
	this.atsScore = atsScore;
	this.suggestions = suggestions;
	this.resume = resume;
}
public AnalysisReport() {
	super();
	// TODO Auto-generated constructor stub


}
}