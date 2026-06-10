package com.hirewise_ai.ai;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.api.url}")
    private String apiUrl;

    private final WebClient webClient;

    public GeminiService(WebClient webClient) {
        this.webClient = webClient;
    }

    // Resume Analysis
    public String analyzeResume(String resumeText) {

        try {

            String prompt = """
                    You are an ATS Resume Analyzer.

                    Analyze this resume and provide:

                    1. ATS Score out of 100
                    2. Strengths
                    3. Missing Skills
                    4. Suggestions

                    Resume:
                    """
                    + resumeText;

            return callGemini(prompt);

        } catch (Exception e) {

            e.printStackTrace();
            return e.getMessage();
        }
    }

    // Generate Interview Questions from Resume
    public String generateInterviewQuestions(String resumeText) {

        try {

            String prompt = """
                    You are a Technical Interviewer.

                    Generate:

                    5 Java Questions
                    5 Spring Boot Questions
                    5 SQL Questions
                    5 HR Questions

                    Resume:
                    """
                    + resumeText;

            return callGemini(prompt);

        } catch (Exception e) {

            e.printStackTrace();
            return e.getMessage();
        }
    }

    // Generate Single Interview Question
    public String generateQuestion() {

        try {

            String prompt = """
                    Generate one Java interview question only.

                    Do not provide answer.

                    Return only the question.
                    """;

            return callGemini(prompt);

        } catch (Exception e) {

            e.printStackTrace();
            return e.getMessage();
        }
    }

    // Evaluate Candidate Answer
    public String evaluateAnswer(
            String question,
            String answer) {

        try {

            String prompt = """
                    You are a Java Technical Interviewer.

                    Evaluate the candidate answer.

                    Return ONLY valid JSON.

                    {
                      "score": 0,
                      "strengths": "",
                      "weaknesses": "",
                      "improvedAnswer": ""
                    }

                    Question:
                    """
                    + question
                    + "\n\nAnswer:\n"
                    + answer;

            return callGemini(prompt);

        } catch (Exception e) {

            e.printStackTrace();
            return e.getMessage();
        }
    }

    // Common Gemini API Call Method
    private String callGemini(String prompt) {

        try {

            Map<String, Object> body =
                    Map.of(
                            "contents",
                            List.of(
                                    Map.of(
                                            "role", "user",
                                            "parts",
                                            List.of(
                                                    Map.of(
                                                            "text",
                                                            prompt)
                                            )
                                    )
                            )
                    );

            String response = webClient.post()
                    .uri(apiUrl + "?key=" + apiKey)
                    .bodyValue(body)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.readTree(response);

            return root
                    .path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();

        } catch (Exception e) {

            e.printStackTrace();

            return "Gemini API Error: " + e.getMessage();
        }
    }
    
    // Match Resume with Job Description
    
    public String matchResumeWithJob(String resume, String jobDescription) {

        try {

            String prompt = """
                    You are an ATS (Applicant Tracking System).

                    Compare Resume and Job Description.

                    Return ONLY valid JSON:

                    {
                      "matchPercentage": 0,
                      "missingSkills": "",
                      "suggestions": ""
                    }

                    Resume:
                    """ + resume + """

                    Job Description:
                    """ + jobDescription;

            return callGemini(prompt);

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}