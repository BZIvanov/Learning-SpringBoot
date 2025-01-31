# Spring Boot config @Bean demo

Example of config bean.

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

## @Configuration

- **Purpose** - Marks a class as a configuration class that defines Spring beans
- **How it works** - Classes annotated with `@Configuration` are processed by Spring, and methods inside them annotated with `@Bean` define beans.
- **Use Case** - When you need to explicitly declare and configure beans in a centralized manner

## @Bean

`@Bean` is an annotation used to indicate that a method will return an object that should be registered as a Spring Bean in the application context. It is typically used within a `@Configuration`-annotated class to define and configure beans programmatically.

### When to Use?

- when you need to register beans that are not part of your application’s source code
- when you want more control over the instantiation logic
- when component scanning (`@Component`) is not possible or practical

### Example

```java
@Configuration
public class MyConfiguration {
    // Bean named name, it is using the method name by default
    @Bean
    public String name() {
        return "John";
    }

    @Bean
    public Integer age() { // do not use primitives like int here to ensure proper beans management
        return 27;
    }

    // Let Spring inject name and age
    @Bean
    public Person myFirstPerson(String name, int age) {
        return new Person(name, age);
    }

    // Bean with custom name
    @Bean("johnDoe")
    public Person mySecondPerson() {
        return new Person("John", 30);
    }
}
```

### ☕ Java Bean vs. 🌱 Spring Bean

| Feature                  | **Java Bean**                                                                                                        | **Spring Bean**                                                        |
| ------------------------ | -------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------- |
| **Definition**           | A reusable Java object following specific conventions.                                                               | An object managed by the Spring Container.                             |
| **Requirements**         | 1️⃣ Public no-arg constructor. <br> 2️⃣ Private fields with public getters & setters. <br> 3️⃣ Serializable (optional). | No strict rules—just an object registered in the Spring IoC container. |
| **Management**           | Manually created using `new ClassName()` in Java.                                                                    | Created & managed by Spring (`@Component`, `@Bean`, etc.).             |
| **Dependency Injection** | No built-in DI support—manual wiring.                                                                                | Supports DI via Spring.                                                |
| **Lifecycle Management** | Created & destroyed by the developer.                                                                                | Spring handles creation, initialization, and destruction.              |
