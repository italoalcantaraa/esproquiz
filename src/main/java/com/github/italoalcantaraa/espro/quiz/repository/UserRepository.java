package com.github.italoalcantaraa.espro.quiz.repository;

import com.github.italoalcantaraa.espro.quiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
    List<User> findAllByOrderByScoreDescTimerAsc();
}
