package com.example.demo;

import com.example.demo.config.AppConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ProfileDemoRunner implements CommandLineRunner {
    private final AppConfig appConfig;
    private final Environment environment;

    public ProfileDemoRunner(AppConfig appConfig, Environment environment) {
        this.appConfig = appConfig;
        this.environment = environment;
    }

    @Override
    public void run(String... args) {
        System.out.println("==================================");
        System.out.println("Active Profiles: " + String.join(", ", environment.getActiveProfiles()));
        System.out.println("Environment: " + appConfig.getEnvironment());
        System.out.println("Message: " + appConfig.getMessage());
        System.out.println("==================================");
    }
}
