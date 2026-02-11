package com.github.italoalcantaraa.espro.quiz.service;

import com.github.italoalcantaraa.espro.quiz.dto.request.LoginRequestDTO;
import com.github.italoalcantaraa.espro.quiz.dto.request.QuestionnaireDataRequestDTO;
import com.github.italoalcantaraa.espro.quiz.dto.response.LoginResponseDTO;
import com.github.italoalcantaraa.espro.quiz.dto.response.UserResponseDTO;
import com.github.italoalcantaraa.espro.quiz.exception.UserDataException;
import com.github.italoalcantaraa.espro.quiz.exception.UserNotFoundException;
import com.github.italoalcantaraa.espro.quiz.model.ParticipationCode;
import com.github.italoalcantaraa.espro.quiz.model.User;
import com.github.italoalcantaraa.espro.quiz.repository.ParticipationCodeRepository;
import com.github.italoalcantaraa.espro.quiz.repository.UserRepository;
import com.github.italoalcantaraa.espro.quiz.validations.user.DefaultUserValidator;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ParticipationCodeRepository participationCodeRepository;
    private final DefaultUserValidator defaultUserValidator;

    public UserService(UserRepository userRepository, ParticipationCodeRepository participationCodeRepository, DefaultUserValidator defaultUserValidator) {
        this.userRepository = userRepository;
        this.participationCodeRepository = participationCodeRepository;
        this.defaultUserValidator = defaultUserValidator;
    }

    public UserResponseDTO findUserById(String id) {
        defaultUserValidator.validateUserSearchById(id);

        int idParseInt = Integer.parseInt(id);

        User user = userRepository.findById(idParseInt).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

        return UserResponseDTO.fromEntity(user);
    }

    public List<UserResponseDTO> findAllUsers() {
        List<User> users = userRepository.findAllByOrderByScoreDescTimerAsc();

        return users.stream().map(UserResponseDTO::fromEntity).toList();
    }

    public LoginResponseDTO joinQuiz(LoginRequestDTO request) {
        defaultUserValidator.validateJoinQuiz(request);

        ParticipationCode code = participationCodeRepository
                .findById(request.participationCode())
                .orElseThrow(() -> new UserDataException("Código inválido."));

        if (code.getUser() != null) {
            if (!code.getUser().getUsername().equals(request.username())) {
                throw new UserDataException("Usuário e/ou código inválidos.");
            }

            return LoginResponseDTO.fromEntity(code.getUser());
        }

        User newUser = new User();
        newUser.setUsername(request.username());
        newUser.setParticipationCode(code);

        User savedUser = userRepository.save(newUser);

        return LoginResponseDTO.fromEntity(savedUser);
    }

    public void sendQuestionnaireData(QuestionnaireDataRequestDTO request) {
        User user = userRepository.findById(request.userId()).orElseThrow(() -> new UserNotFoundException("Usuário nao enconstrado."));
        user.setTimer(LocalTime.parse(request.timer()));
        user.setScore(request.totalScore());

        userRepository.save(user);
    }
}
