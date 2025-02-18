# Beans wiring demo

The Teacher bean depends on the Subject bean, demonstrating how Spring injects dependencies automatically.

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.2
- Dependencies:
  - Spring Web

## How is Spring managing this wiring?

1. Spring IoC container registers both beans (Subject and Teacher) from the @Bean methods in SchoolConfig.
2. Spring automatically injects Subject into Teacher via constructor injection.
3. When requesting a Teacher bean, Spring first ensures that a Subject bean exists and passes it to the Teacher bean.
