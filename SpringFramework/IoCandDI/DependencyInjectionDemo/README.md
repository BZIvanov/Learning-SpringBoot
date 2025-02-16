# Dependency Injection demo

Demonstrates Dependency Injection and managing multiple implementations with `@Qualifier`.

## Demo usage

Open `http://localhost:8080` to access the endpoint.

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.2
- Dependencies:
  - Spring Web

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

    @GetMapping("/")
    public String greet() {
        return greetingService.greet();
    }
}
```
