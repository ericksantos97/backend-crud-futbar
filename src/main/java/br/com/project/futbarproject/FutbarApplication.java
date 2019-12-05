package br.com.project.futbarproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FutbarApplication {

	public static void main(String[] args) {
		SpringApplication.run(FutbarApplication.class, args);
	}

}
