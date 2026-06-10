package com.hirewise_ai.controller;

import org.springframework.web.bind.annotation.*;

import com.hirewise_ai.dto.MockInterviewRequestDTO;
import com.hirewise_ai.dto.MockInterviewResponseDTO;
import com.hirewise_ai.service.MockInterviewService;

@RestController
@RequestMapping("/mock-interview")
public class MockInterviewController {

    private final MockInterviewService service;

    public MockInterviewController(MockInterviewService service) {

        this.service = service;
    }

    @PostMapping("/evaluate")
    public MockInterviewResponseDTO evaluate(@RequestBody MockInterviewRequestDTO request) {

        return service.evaluate(request);
    }
}