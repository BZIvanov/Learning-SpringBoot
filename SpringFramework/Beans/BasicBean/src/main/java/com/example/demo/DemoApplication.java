package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// we can use @Bean annotation here, because @SpringBootApplication itself is annotated with @Configuration
	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner -> {
			System.out.println("Project has started ✅");
		};
	}
}
