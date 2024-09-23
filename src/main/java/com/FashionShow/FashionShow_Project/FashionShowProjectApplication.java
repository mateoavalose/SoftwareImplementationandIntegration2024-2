package com.FashionShow.FashionShow_Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class FashionShowProjectApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("CONNECTION_URL", dotenv.get("CONNECTION_URL"));
		System.setProperty("USER", dotenv.get("USER"));
		System.setProperty("PASSWORD", dotenv.get("PASSWORD"));

		SpringApplication.run(FashionShowProjectApplication.class, args);
	}

}
