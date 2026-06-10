package com.hirewise_ai.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fileName;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String resumeText;

    private LocalDateTime uploadDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Resume() {
    }

    public Resume(int id, String fileName, String resumeText,
                  LocalDateTime uploadDate, User user) {
        this.id = id;
        this.fileName = fileName;
        this.resumeText = resumeText;
        this.uploadDate = uploadDate;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getResumeText() {
        return resumeText;
    }

    public void setResumeText(String resumeText) {
        this.resumeText = resumeText;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}