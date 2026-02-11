package com.github.italoalcantaraa.espro.quiz.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tb_participation_code")
@Entity
public class ParticipationCode {

    @Id
    private String code;

    @OneToOne(mappedBy = "participationCode")
    private User user;
}
