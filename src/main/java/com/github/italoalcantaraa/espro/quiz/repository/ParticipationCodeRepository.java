package com.github.italoalcantaraa.espro.quiz.repository;

import com.github.italoalcantaraa.espro.quiz.model.ParticipationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationCodeRepository extends JpaRepository<ParticipationCode, String> {
    boolean existsByCode(String code);
}
