package com.backend_challenge.service;

import com.backend_challenge.dto.PasswordRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class PasswordValidationServiceImpl implements PasswordValidationService {

    @Override
    public boolean isValid(PasswordRequest request) {

        if (request == null || request.password() == null) {
            return false;
        }

        String password = request.password();

        if (password.isBlank() || password.length() < 9) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // Set para tirar caracteres duplicados
        Set<Character> chars = new HashSet<>();

        // Caracteres especiais permitidos
        String spcCaracters = "!@#$%^&*()-+";

        // Verifica cada caractere da senha
        for (char c : request.password().toCharArray())  {

            // Verifica se o caractere é um espaço em branco
            if (Character.isWhitespace(c)) return false;
            if (!chars.add(c)) return false; // Verifica se o caractere já foi adicionado ao conjunto (duplicado)

            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (spcCaracters.indexOf(c) >= 0) {
                hasSpecial = true;
            }
        }

        return hasUpper
                && hasLower
                && hasDigit
                && hasSpecial;
    }
}
