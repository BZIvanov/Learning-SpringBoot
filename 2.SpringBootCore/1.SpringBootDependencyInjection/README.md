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

## @Component annotation

`@Component` is a Spring annotation used to mark a Java class as a Spring-managed bean. It allows Spring to automatically detect and register the class in the application context during component scanning.

### Key Points

- Used for general-purpose Spring beans.
- Enables dependency injection via `@Autowired`.
- Part of the stereotype annotations (`@Service`, `@Repository`, `@Controller`), which are specialized versions of `@Component`.
- Requires component scanning (`@ComponentScan` or auto-configuration).

### Example

```java
@Component
public class MyBean {
    public void doSomething() {
        System.out.println("Hello from MyBean!");
    }
}
```

## @Primary annotation

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

## @Qualifier annotation

`@Qualifier` is a Spring annotation used to resolve ambiguity when multiple beans of the same type exist. It helps specify which bean should be injected when using `@Autowired`.

### Key Points

- Used alongside `@Autowired` to select a specific bean.
- Helps avoid `NoUniqueBeanDefinitionException`.
- The value inside `@Qualifier` must match the bean’s name.

### Example

```java
@Component("beanA")
public class BeanA implements MyService { }

@Component("beanB")
public class BeanB implements MyService { }

@Autowired
@Qualifier("beanA") // Specifies which bean to inject
private MyService myService;
```
