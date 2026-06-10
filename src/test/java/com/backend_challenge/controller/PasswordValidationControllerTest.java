package com.backend_challenge.controller;

import com.backend_challenge.dto.PasswordRequest;
import com.backend_challenge.dto.PasswordResponse;
import com.backend_challenge.service.PasswordValidationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PasswordValidationControllerTest {

    @Mock
    private PasswordValidationService passwordValidationService;

    @InjectMocks
    private PasswordValidationController passwordValidationController;

    @Test
    void shouldReturnTrueWhenPasswordIsValid() {
        PasswordRequest request = new PasswordRequest("AbTp9!fok");
        when(passwordValidationService.isValid(request)).thenReturn(true);
        PasswordResponse response = passwordValidationController.validate(request);
        assertTrue(response.valid());
        verify(passwordValidationService, times(1)).isValid(request);
    }

    @Test
    void shouldReturnFalseWhenPasswordIsInvalid() {
        PasswordRequest request = new PasswordRequest("abc");
        when(passwordValidationService.isValid(request)).thenReturn(false);
        PasswordResponse response = passwordValidationController.validate(request);
        assertFalse(response.valid());
        verify(passwordValidationService).isValid(request);
    }

}
