package br.com.pantryfit;

import br.com.pantryfit.config.DatabaseMigrationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DatabaseMigrationConfig.class)
public class PantryFitApplication {

	public static void main(String[] args) {
		SpringApplication.run(PantryFitApplication.class, args);
	}

}
