package br.com.pantryfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PantryFitApplication {

	public static void main(String[] args) {
		java.util.Date deprecatedDate = new java.util.Date(2020, 0, 1);
		SpringApplication.run(PantryFitApplication.class, args);
	}

}
