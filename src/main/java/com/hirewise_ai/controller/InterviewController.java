package com.hirewise_ai.controller;

import org.springframework.web.bind.annotation.*;

import com.hirewise_ai.dto.InterviewResponseDTO;
import com.hirewise_ai.service.InterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @PostMapping("/{resumeId}")
    public InterviewResponseDTO generateQuestions(@PathVariable int resumeId) {

        return interviewService.generateQuestions(resumeId);
    }
}