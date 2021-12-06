package com.ensolvers.webexercise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ensolvers.webexercise.domain.User;
import com.ensolvers.webexercise.repositories.IFolderRepository;
import com.ensolvers.webexercise.repositories.IUserRepository;

@SpringBootApplication
public class WebexerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebexerciseApplication.class, args);
	}
	


}
