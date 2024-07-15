package com.example.aopdemo;

import com.example.aopdemo.dao.DatabaseLogger;
import com.example.aopdemo.dao.FileLogger;
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
	public CommandLineRunner commandLineRunner(
			DatabaseLogger databaseLogger,
			FileLogger fileLogger
	) {
		return runner -> {
			demoTheBeforeAdvice(databaseLogger, fileLogger);
		};
	}

	private void demoTheBeforeAdvice(
			DatabaseLogger databaseLogger,
			FileLogger fileLogger
	) {
		// calling all methods and you will see Aspect logs in the console only for methods matching the @Before pattern

		databaseLogger.addUser();
		databaseLogger.addProduct();
		databaseLogger.addSum(3, 4);
		databaseLogger.addCustomValue(new CustomValue("apple"));
		databaseLogger.addCustomValue(new CustomValue("kiwi"), 23);
		fileLogger.addUser();
	}
}
