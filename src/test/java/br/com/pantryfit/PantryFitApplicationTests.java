package br.com.pantryfit;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
class PantryFitApplicationTests {

	@Test
	void contextLoads(ApplicationContext applicationContext) {
		assertNotNull(applicationContext);
	}

}
