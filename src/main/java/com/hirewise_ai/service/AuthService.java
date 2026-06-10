package com.hirewise_ai.service;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hirewise_ai.dto.LoginRequestDTO;
import com.hirewise_ai.dto.RegisterRequestDTO;
import com.hirewise_ai.entity.User;
import com.hirewise_ai.repository.UserRepository;
import com.hirewise_ai.security.JwtService;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }
    

    public String register(RegisterRequestDTO request) {

        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole("USER");

        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        return "User Registered Successfully";
    }

    public String login(LoginRequestDTO request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid Email"));

        if(!passwordEncoder.matches(request.getPassword(),user.getPassword())) {

            throw new RuntimeException("Invalid Password");
        }

        return jwtService.generateToken(user.getEmail());
    }
    
}