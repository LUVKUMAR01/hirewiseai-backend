package com.hirewise_ai.service;

import org.springframework.stereotype.Service;

import com.hirewise_ai.ai.GeminiService;
import com.hirewise_ai.dto.MockInterviewRequestDTO;
import com.hirewise_ai.dto.MockInterviewResponseDTO;
import com.hirewise_ai.entity.MockInterview;
import com.hirewise_ai.repository.MockInterviewRepository;

@Service
public class MockInterviewService {

    private final GeminiService geminiService;
    private final MockInterviewRepository repository;

    public MockInterviewService(GeminiService geminiService,MockInterviewRepository repository) {

        this.geminiService = geminiService;
        this.repository = repository;
    }

    public String generateQuestion() {

        return geminiService.generateQuestion();
    }

    public MockInterviewResponseDTO evaluate(MockInterviewRequestDTO request) {

        String feedback = geminiService.evaluateAnswer(request.getQuestion(),request.getAnswer());

        MockInterview mock = new MockInterview();

        mock.setQuestion(request.getQuestion());
        mock.setAnswer(request.getAnswer());
        mock.setFeedback(feedback);

        repository.save(mock);

        MockInterviewResponseDTO dto = new MockInterviewResponseDTO();

        dto.setFeedback(feedback);

        return dto;
    }
}