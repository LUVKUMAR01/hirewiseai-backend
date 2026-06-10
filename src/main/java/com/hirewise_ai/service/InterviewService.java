package com.hirewise_ai.service;

import org.springframework.stereotype.Service;

import com.hirewise_ai.ai.GeminiService;
import com.hirewise_ai.dto.InterviewResponseDTO;
import com.hirewise_ai.entity.InterviewQuestion;
import com.hirewise_ai.entity.Resume;
import com.hirewise_ai.repository.InterviewQuestionRepository;
import com.hirewise_ai.repository.ResumeRepository;

@Service
public class InterviewService {

    private final ResumeRepository resumeRepository;
    private final InterviewQuestionRepository questionRepository;
    private final GeminiService geminiService;

    public InterviewService(ResumeRepository resumeRepository,InterviewQuestionRepository questionRepository,
            GeminiService geminiService) {

        this.resumeRepository = resumeRepository;
        this.questionRepository = questionRepository;
        this.geminiService = geminiService;
    }

    public InterviewResponseDTO generateQuestions(int resumeId) {

        Resume resume = resumeRepository
                .findById(resumeId)
                .orElseThrow(() ->
                        new RuntimeException("Resume Not Found"));

        String response = geminiService.generateInterviewQuestions(resume.getResumeText());

        InterviewQuestion question = new InterviewQuestion();

        question.setQuestions(response);
        question.setResume(resume);

        questionRepository.save(question);

        InterviewResponseDTO dto = new InterviewResponseDTO();

        dto.setQuestions(response);

        return dto;
    }
}