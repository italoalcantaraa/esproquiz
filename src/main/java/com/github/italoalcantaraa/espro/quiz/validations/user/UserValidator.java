package com.github.italoalcantaraa.espro.quiz.validations.user;

import com.github.italoalcantaraa.espro.quiz.dto.request.LoginRequestDTO;

public interface UserValidator {
    void validateJoinQuiz(LoginRequestDTO request);
    void validateUserSearchById(String id);
}
