package com.github.italoalcantaraa.espro.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizApplication {
	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(QuizApplication.class);
        app.run(args);
	}
}
