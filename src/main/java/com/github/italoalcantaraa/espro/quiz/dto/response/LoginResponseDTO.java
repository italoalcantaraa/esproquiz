package com.github.italoalcantaraa.espro.quiz.dto.response;

import com.github.italoalcantaraa.espro.quiz.model.User;

public record LoginResponseDTO (int id, String username){
    public static LoginResponseDTO fromEntity(User user) {
        return new LoginResponseDTO(user.getId(), user.getUsername());
    }
}
