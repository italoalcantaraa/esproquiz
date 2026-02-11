package com.github.italoalcantaraa.espro.quiz.validations.user;

import com.github.italoalcantaraa.espro.quiz.validations.ValidationErrorRegistry;

public interface UsernameValidator {
    default void validateName(String name) {
        if(name == null || name.isEmpty()) {
            ValidationErrorRegistry.addError("Informe o nome");
            return;
        }

        // verifica se o nome tem número
        name.chars().forEach(c -> {
            if(Character.isDigit(c)) {
                ValidationErrorRegistry.addError("Não pode conter números");
                return;
            };
        });
    }
}
