package com.example.aopdemo;

import com.example.aopdemo.dao.DatabaseLogger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(DatabaseLogger databaseLogger) {
		return runner -> {
			demoAfterAdvice(databaseLogger);
		};
	}

	private void demoAfterAdvice(DatabaseLogger databaseLogger) {
		List<CustomValue> values = null;

		try {
			// change the parameter to true/false to test both scenarios
			// with false only @After annotation will run
			// with true both @AfterThrowing and @After will run, because of the error and finally
			values = databaseLogger.findValues(true);
		}
		catch (Exception exc) {
			System.out.println("APP EXCEPTION: " + exc);
		}

		System.out.println("APP VALUES: " + values);
	}
}
