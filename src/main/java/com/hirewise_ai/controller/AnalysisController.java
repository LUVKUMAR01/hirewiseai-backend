package com.hirewise_ai.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hirewise_ai.dto.AnalysisResponseDTO;
import com.hirewise_ai.service.AnalysisService;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {

    private final AnalysisService analysisService;

    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping("/ats/{resumeId}")
    public AnalysisResponseDTO analyzeResume(@PathVariable int resumeId) {

        return analysisService.analyzeResume(resumeId);
    }
}