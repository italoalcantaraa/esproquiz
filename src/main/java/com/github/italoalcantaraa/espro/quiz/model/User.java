package com.github.italoalcantaraa.espro.quiz.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Table(name = "tb_user")
@Entity
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(nullable = false, unique = true)
private String username;

private int score;

private LocalTime timer;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "participation_code")
private ParticipationCode participationCode;
}
