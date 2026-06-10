package com.hirewise_ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hirewise_ai.entity.MockInterview;

public interface MockInterviewRepository extends JpaRepository<MockInterview, Integer> {

}
