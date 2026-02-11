package com.github.italoalcantaraa.espro.quiz.dto.response;

import com.github.italoalcantaraa.espro.quiz.model.User;

import java.time.LocalTime;

public record UserResponseDTO(String username, Integer score, LocalTime timer, String participationCode) {
    public static UserResponseDTO fromEntity(User user) {
        return new UserResponseDTO(
                user.getUsername(),
                user.getScore(),
                user.getTimer(),
                user.getParticipationCode().getCode());
    }
}
