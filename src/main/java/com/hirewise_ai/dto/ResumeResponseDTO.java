package com.hirewise_ai.dto;

public class ResumeResponseDTO {

    private int id;
    private String fileName;
    private String uploadDate;

    public ResumeResponseDTO() {
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

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

	public ResumeResponseDTO(int id, String fileName, String uploadDate) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.uploadDate = uploadDate;
	}
    
}
