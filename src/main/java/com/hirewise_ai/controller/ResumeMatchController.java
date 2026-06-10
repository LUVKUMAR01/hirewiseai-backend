package com.hirewise_ai.controller;

import org.springframework.web.bind.annotation.*;

import com.hirewise_ai.service.ResumeMatchService;

@RestController
@RequestMapping("/resume")
public class ResumeMatchController {

    private final ResumeMatchService resumeMatchService;

    public ResumeMatchController(ResumeMatchService resumeMatchService) {
        this.resumeMatchService = resumeMatchService;
    }

    @PostMapping("/match")
    public String match(@RequestBody String text) {
        return resumeMatchService.matchResume(text);
    }
}