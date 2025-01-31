# Spring Boot dependency injection demo

Example of dependency injection.

Open `http://localhost:8080/subject` to access the endpoint.

## Project configs

Here is a list of how this project was configured in the Spring Initializr

- Project: Maven
- Language: Java
- Spring Boot: 3.3.0
- Project Metadata:
  - Group: com.example
  - Artifact: mycoolapp
  - Name: mycoolapp
  - Description: Demo project for Spring Boot
  - Package Name: com.example.mycoolapp
  - Packaging: JAR
  - Java: 22
- Dependencies:
  - Spring Web
  - Spring Boot DevTools

## Primary and Qualifier annotations

You can find example of the Qualifier annotation in this demo and similar solution with Primary annotation is provided below.

#### Primary annotation

The `@Primary` annotation is used to indicate that a specific bean should be given preference when multiple candidates are qualified to autowire a single-valued dependency.

Below is our interface.

```java
public interface GreetingService {
    String greet();
}
```

And here are our 2 classes, for one of them we will specify Primary annotation.

```java
@Primary
@Service
public class EnglishGreetingService implements GreetingService {
    @Override
    public String greet() {
        return "Hello";
    }
}
```

```java
@Service
public class SpanishGreetingService implements GreetingService {
    @Override
    public String greet() {
        return "Hola";
    }
}
```

Now, when starting our application the EnglishGreetingService will be injected as GreetingService.

```java
@RestController
public class GreetingController {
    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greet")
    public String greet() {
        return greetingService.greet();
    }
}
```
