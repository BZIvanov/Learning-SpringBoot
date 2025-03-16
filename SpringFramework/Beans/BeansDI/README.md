# Spring Boot Bean Configuration & Dependency Injection demo

This demo showcases how to define and retrieve Spring beans using `@Configuration` and `@Bean`.

- `StudentConfig` (Configuration Class):
  - Defines beans for `firstName`, `lastName` and `fullName`.
  - Uses method parameter injection to ensure Spring manages dependencies properly.
- `DemoRunner` (Component Class):
  - Retrieves beans using `ApplicationContext#getBean()`.
  - Demonstrates type-safe retrieval with `getBean("beanName", String.class)`.
  - Prints values to the console.

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- No dependencies
