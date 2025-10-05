package com.ecom.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

import com.ecom.dto.register.RegistrationRequest;
import com.ecom.dto.register.RegistrationResponse;
import com.ecom.service.RegistrationService;


@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest registrationRequest) {
        return ResponseEntity.ok(registrationService.register(registrationRequest));
    }
}