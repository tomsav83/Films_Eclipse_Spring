package com.qa.films;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.films.rest.FilmsController;
import com.qa.films.service.FilmService;

@SpringBootApplication
public class FilmsApplication {

	public static void main(String[] args) {
			ApplicationContext context = SpringApplication.run(FilmsApplication.class, args);
			System.out.println("SERVICE: " + context.getBean(FilmService.class));
			System.out.println("CONTROLLER: " + context.getBean(FilmsController.class)); // for demo purposes - (context is a list)
			

	}

}
