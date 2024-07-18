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
			demoAfterThrowingAdvice(databaseLogger);
		};
	}

	private void demoAfterThrowingAdvice(DatabaseLogger databaseLogger) {
		List<CustomValue> values = null;

		try {
			values = databaseLogger.findValues(true);
		}
		catch (Exception exc) {
			System.out.println("APP EXCEPTION: " + exc);
		}

		System.out.println("APP VALUES: " + values);
	}
}
