package com.github.italoalcantaraa.espro.quiz.validations.user;

import com.github.italoalcantaraa.espro.quiz.dto.request.LoginRequestDTO;
import com.github.italoalcantaraa.espro.quiz.exception.UserDataException;
import com.github.italoalcantaraa.espro.quiz.validations.ValidationErrorRegistry;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserValidator implements UserValidator, UsernameValidator, CodeValidator {

    @Override
    public void validateJoinQuiz(LoginRequestDTO request) {
        validateCode(request.participationCode());
        validateName(request.username());

        // retorna caso não haja erros na lista
        if (!ValidationErrorRegistry.hasErrors()) {
            return;
        }

        // captura a mensagem de erro
        String errorMessage = ValidationErrorRegistry.getErrorMessage();

        throw new UserDataException(errorMessage);
    }

    @Override
    public void validateUserSearchById(String id) {
        Integer stringToInteger = null;

        try {
            stringToInteger = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new UserDataException("ID inválido");
        }
    }
}
