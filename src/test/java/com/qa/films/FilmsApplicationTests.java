package com.qa.films;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // sets active profile to test which overrides the default in main application.properties
class FilmsApplicationTests {

	@Test
	void contextLoads() {
	}

}
