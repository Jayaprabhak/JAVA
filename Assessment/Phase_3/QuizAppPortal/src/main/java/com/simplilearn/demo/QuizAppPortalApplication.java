package com.simplilearn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan("com.simplilearn.demo")
public class QuizAppPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizAppPortalApplication.class, args);
	}

}
