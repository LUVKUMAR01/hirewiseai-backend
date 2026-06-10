package com.hirewise_ai.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hirewise_ai.dto.ResumeResponseDTO;
import com.hirewise_ai.service.ResumeService;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    private final ResumeService resumeService;
  
    public ResumeController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
    

	@PostMapping("/upload")
    public ResumeResponseDTO uploadResume(@RequestParam("file")MultipartFile file,@RequestParam("userId")int userId)
            throws Exception {
        return resumeService.uploadResume(file,userId);
    }
}
