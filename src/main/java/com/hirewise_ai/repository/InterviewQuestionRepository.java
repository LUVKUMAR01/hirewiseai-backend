package com.hirewise_ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hirewise_ai.entity.InterviewQuestion;

public interface InterviewQuestionRepository extends JpaRepository<InterviewQuestion, Integer> {

}
