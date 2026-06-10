package com.backend_challenge.service;

import com.backend_challenge.dto.PasswordRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidationServiceImplTest {

    private PasswordValidationServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new PasswordValidationServiceImpl();
    }

    @Test
    @DisplayName("Deve retornar false quando request for null")
    void shouldReturnFalseWhenRequestIsNull() {
        assertFalse(service.isValid(null));
    }

    @Test
    @DisplayName("Deve retornar false quando senha for null")
    void shouldReturnFalseWhenPasswordIsNull() {
        PasswordRequest request = new PasswordRequest(null);
        assertFalse(service.isValid(request));
    }

    @ParameterizedTest
    @CsvSource({
            "'', false",
            "' ', false",
            "'123', false",
            "'AbTp9!fo', false",
            "'AbTp9 fok', false",
            "'AbTp9!foo', false",
            "'abtp9!fok', false",
            "'ABTP9!FOK', false",
            "'AbTp!fokZ', false",
            "'AbTp9fokZ', false",
            "'AbTp9!fok', true"
    })
    @DisplayName("Deve validar corretamente as regras da senha")
    void shouldValidatePassword(String password, boolean expected) {
        PasswordRequest request = new PasswordRequest(password);
        boolean result = service.isValid(request);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Deve retornar false quando possuir espaço em branco")
    void shouldReturnFalseWhenContainsWhitespace() {
        PasswordRequest request = new PasswordRequest("AbTp9 fok");
        assertFalse(service.isValid(request));
    }

    @Test
    @DisplayName("Deve retornar false quando possuir caracteres repetidos")
    void shouldReturnFalseWhenContainsRepeatedCharacters() {
        PasswordRequest request = new PasswordRequest("AbTp9!foo");
        assertFalse(service.isValid(request));
    }

    @Test
    @DisplayName("Deve retornar true para senha válida")
    void shouldReturnTrueWhenPasswordIsValid() {
        PasswordRequest request = new PasswordRequest("AbTp9!fok");
        assertTrue(service.isValid(request));
    }
}
