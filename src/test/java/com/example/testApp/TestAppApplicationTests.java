package com.example.testApp;

import com.example.testApp.init.PostgresInit;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ActiveProfiles("test")
@SpringBootTest
@ContextConfiguration(initializers = {PostgresInit.Initializer.class})
@Transactional
public class TestAppApplicationTests {

	@BeforeAll
	static void init() {
		PostgresInit.container.start();
	}

	@AfterAll
	static void afterAll() {
		PostgresInit.container.close();
	}

}
