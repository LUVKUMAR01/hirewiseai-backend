package com.hirewise_ai.service;

import org.springframework.stereotype.Service;

import com.hirewise_ai.ai.GeminiService;
import com.hirewise_ai.dto.AnalysisResponseDTO;
import com.hirewise_ai.entity.AnalysisReport;
import com.hirewise_ai.entity.Resume;
import com.hirewise_ai.repository.AnalysisReportRepository;
import com.hirewise_ai.repository.ResumeRepository;

@Service
public class AnalysisService {

    private final ResumeRepository resumeRepository;
    private final AnalysisReportRepository reportRepository;
    private final GeminiService geminiService;

    public AnalysisService(ResumeRepository resumeRepository,AnalysisReportRepository reportRepository,
            GeminiService geminiService) {

        this.resumeRepository = resumeRepository;
        this.reportRepository = reportRepository;
        this.geminiService = geminiService;
    }
    
    public AnalysisResponseDTO analyzeResume(int resumeId) {

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume Not Found"));

        String resumeText = resume.getResumeText();

        String aiResponse = geminiService.analyzeResume(resumeText);

        AnalysisReport report = new AnalysisReport();

        report.setAtsScore(0);
        report.setSuggestions(aiResponse);
        report.setResume(resume);

        reportRepository.save(report);

        AnalysisResponseDTO response = new AnalysisResponseDTO();

        response.setAtsScore(0);
        response.setSuggestions(aiResponse);

        return response;
    }
}
