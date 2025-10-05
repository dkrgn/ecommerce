package com.ecom.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecom.dto.register.RegistrationRequest;
import com.ecom.dto.register.RegistrationResponse;
import com.ecom.exception.UserAlreadyExistsException;
import com.ecom.model.User;
import com.ecom.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public RegistrationResponse register(RegistrationRequest registrationRequest) {
        if (userRepository.getUserByEmail(registrationRequest.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User with email: " + registrationRequest.getEmail() + " already exists.");
        }
        User user = new User(registrationRequest);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return new RegistrationResponse(user);
    }
}