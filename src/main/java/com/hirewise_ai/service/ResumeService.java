package com.hirewise_ai.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hirewise_ai.dto.ResumeResponseDTO;
import com.hirewise_ai.entity.Resume;
import com.hirewise_ai.entity.User;
import com.hirewise_ai.parser.PdfParserService;
import com.hirewise_ai.repository.ResumeRepository;
import com.hirewise_ai.repository.UserRepository;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final UserRepository userRepository;
    private final PdfParserService parserService;
    

    public ResumeService(ResumeRepository resumeRepository, UserRepository userRepository,
			PdfParserService parserService) {
		super();
		this.resumeRepository = resumeRepository;
		this.userRepository = userRepository;
		this.parserService = parserService;
	}


	public ResumeResponseDTO uploadResume(MultipartFile file,int userId)
            throws Exception {
        User user = userRepository.findById(userId).orElseThrow();

        String resumeText =parserService.extractText(file);

        Resume resume = new Resume();

        resume.setFileName(file.getOriginalFilename());
        resume.setResumeText(resumeText);
        resume.setUploadDate(LocalDateTime.now());
        resume.setUser(user);

        Resume saved =resumeRepository.save(resume);

        ResumeResponseDTO response = new ResumeResponseDTO();

        response.setId(saved.getId());
        response.setFileName(saved.getFileName());
        response.setUploadDate(saved.getUploadDate().toString());

        return response;
    }

}
