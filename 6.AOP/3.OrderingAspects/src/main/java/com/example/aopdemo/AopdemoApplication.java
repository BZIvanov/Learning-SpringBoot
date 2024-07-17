package com.example.aopdemo;

import com.example.aopdemo.dao.DatabaseLogger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(DatabaseLogger databaseLogger) {
		return runner -> {
			demoTheBeforeAdvice(databaseLogger);
		};
	}

	private void demoTheBeforeAdvice(DatabaseLogger databaseLogger) {
		databaseLogger.addUser();

		databaseLogger.setPrefix("111");
		String prefix = databaseLogger.getPrefix();
	}
}
