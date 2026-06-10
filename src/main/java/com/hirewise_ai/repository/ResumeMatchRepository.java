package com.hirewise_ai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hirewise_ai.entity.ResumeMatch;

public interface ResumeMatchRepository extends JpaRepository<ResumeMatch, Integer> {

}
