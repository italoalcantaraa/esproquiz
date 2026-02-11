package com.github.italoalcantaraa.espro.quiz.validations.user;

import com.github.italoalcantaraa.espro.quiz.validations.ValidationErrorRegistry;

public interface CodeValidator {
    default void validateCode(String code) {
        if(code == null || code.isEmpty()) {
            ValidationErrorRegistry.addError("Informe o codigo");
        }
    }
}
