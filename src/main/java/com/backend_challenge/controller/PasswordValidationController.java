package com.backend_challenge.controller;

import com.backend_challenge.service.PasswordValidationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/password")
public class PasswordValidationController {

    private final PasswordValidationService passwordValidationService;

    public PasswordValidationController(PasswordValidationService passwordValidationService) {
        this.passwordValidationService = passwordValidationService;
    }



}
