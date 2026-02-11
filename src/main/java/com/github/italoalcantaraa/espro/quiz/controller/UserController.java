package com.github.italoalcantaraa.espro.quiz.controller;

import com.github.italoalcantaraa.espro.quiz.dto.request.LoginRequestDTO;
import com.github.italoalcantaraa.espro.quiz.dto.request.QuestionnaireDataRequestDTO;
import com.github.italoalcantaraa.espro.quiz.dto.response.LoginResponseDTO;
import com.github.italoalcantaraa.espro.quiz.dto.response.UserResponseDTO;
import com.github.italoalcantaraa.espro.quiz.service.UserService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("questionnaire")
    public ResponseEntity<HttpStatusCode> sendQuestionnaireData(@RequestBody QuestionnaireDataRequestDTO request) {
        userService.sendQuestionnaireData(request);
        return ResponseEntity.status(201).build();
    }

    @PostMapping
    public ResponseEntity<LoginResponseDTO> joinQuiz(@RequestBody LoginRequestDTO request) {
        return ResponseEntity.status(200).body(userService.joinQuiz(request));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable String id) {
        return ResponseEntity.status(200).body(userService.findUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        return ResponseEntity.status(200).body(userService.findAllUsers());
    }
}
