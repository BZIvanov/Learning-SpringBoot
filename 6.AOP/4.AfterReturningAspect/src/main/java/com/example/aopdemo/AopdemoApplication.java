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
			demoTheAfterReturningAdvice(databaseLogger);
		};
	}

	private void demoTheAfterReturningAdvice(DatabaseLogger databaseLogger) {
		List<CustomValue> values = databaseLogger.findValues();

		System.out.println("APP FINAL VALUES: " + values);
	}
}
