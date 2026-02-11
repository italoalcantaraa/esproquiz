package com.github.italoalcantaraa.espro.quiz.controller;

import com.github.italoalcantaraa.espro.quiz.dto.request.ParticipationCodeRequestDTO;
import com.github.italoalcantaraa.espro.quiz.service.ParticipationCodeService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/code")
public class ParticipationCodeController {

    private final ParticipationCodeService participationCodeService;

    public ParticipationCodeController(ParticipationCodeService participationCodeService) {
        this.participationCodeService = participationCodeService;
    }

    @PostMapping
    public ResponseEntity<HttpStatusCode> addParticipationCode(@RequestBody ParticipationCodeRequestDTO request) {
        participationCodeService.addParticipationCode(request);
        return ResponseEntity.status(200).build();
    }
}
