# Component Scan demo

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.2
- Dependencies:
  - Spring Web

## Stereotype annotations

Read [here](https://docs.spring.io/spring-framework/reference/core/beans/classpath-scanning.html) for more info for stereotype annotations.

Stereotype annotations in Spring are used to **declare and register beans** in the Spring IoC container automatically. They are part of Spring’s component-scanning mechanism.

- `@Component` - Generic Bean. Marks a class as a Spring-managed bean (generic)
  - `@Service` - For Service Layer. Specialization of @Component, indicates business logic/services.
  - `@Repository` - For Data Access Layer. Specialization of @Component, used for DAO/repository classes.
  - `@Controller` - For Web Layer. Specialization of @Component, used for MVC controllers.
  - `@RestController` - For REST APIs. Combination of @Controller and @ResponseBody.

### Key points

- `@Component` is the base annotation, and the others (`@Service`, `@Repository`, `@Controller`) are specialized versions of it.
- Spring automatically **scans and registers** these beans if `@ComponentScan` is used.
