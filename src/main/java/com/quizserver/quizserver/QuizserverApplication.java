package com.quizserver.quizserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizserverApplication {

	public static void main(String[] args) {
		System.out.println("hello today");
		SpringApplication.run(QuizserverApplication.class, args);
	}

}
