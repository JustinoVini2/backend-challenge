package com.backend_challenge.service;

import com.backend_challenge.dto.PasswordRequest;
import org.springframework.stereotype.Service;

@Service
public class PasswordValidationServiceImpl implements PasswordValidationService {

    @Override
    public boolean isValid(PasswordRequest request) {
        return false;
    }
}
