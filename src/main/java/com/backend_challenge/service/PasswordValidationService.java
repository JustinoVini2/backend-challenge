package com.backend_challenge.service;

import com.backend_challenge.dto.PasswordRequest;

public interface PasswordValidationService {

    boolean isValid(PasswordRequest request);

}
