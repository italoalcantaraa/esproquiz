package com.github.italoalcantaraa.espro.quiz.service;

import com.github.italoalcantaraa.espro.quiz.dto.request.ParticipationCodeRequestDTO;
import com.github.italoalcantaraa.espro.quiz.model.ParticipationCode;
import com.github.italoalcantaraa.espro.quiz.repository.ParticipationCodeRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipationCodeService {
    private final ParticipationCodeRepository participationCodeRepository;

    public ParticipationCodeService(ParticipationCodeRepository participationCodeRepository) {
        this.participationCodeRepository = participationCodeRepository;
    }

    public void addParticipationCode(ParticipationCodeRequestDTO request) {
        if(participationCodeRepository.existsByCode(request.participationCode())) {
            throw new RuntimeException("Código já cadastrado");
        }

        ParticipationCode participationCode = new ParticipationCode();
        participationCode.setCode(request.participationCode());

        participationCodeRepository.save(participationCode);
    }
}
