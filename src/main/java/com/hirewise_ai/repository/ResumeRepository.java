package com.hirewise_ai.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hirewise_ai.entity.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Integer>{

}
