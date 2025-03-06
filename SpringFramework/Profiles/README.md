# Spring profiles demo

This demo showcases how to use **Spring Profiles** to load different `application-<profile>.properties` files based on the active profile. A configuration class (`AppConfig`) maps properties, and a `CommandLineRunner` (`ProfileDemoRunner`) prints the active profile and its corresponding settings at startup. The active profile can be set via **command-line arguments, environment variables, or application.properties**. Running the application with different profiles (dev, prod, etc.) dynamically loads the appropriate configuration, making it ideal for environment-specific settings in Spring Boot applications.

## Playing with this demo

Run the project and check the console.

Here is one way how to switch to the dev profile `mvn spring-boot:run -Dspring-boot.run.profiles=dev`.

### Setting active profile

In this demo, we will always use the default properties.

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- No dependencies
