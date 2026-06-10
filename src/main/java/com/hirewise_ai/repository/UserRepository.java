package com.hirewise_ai.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hirewise_ai.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}