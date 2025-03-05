# Annotations targeting demo

Example where we have both `@Controller` and `@RestController`, and we use `@RestControllerAdvice(annotations = RestController.class)` to apply exception handling only to `@RestController`, but not to `@Controller`.

## Playing with the demo

- GET `http://localhost:8080/api/user` - since ApiController is a @RestController, the exception will be caught by ApiExceptionHandler.
- GET `http://localhost:8080/web/user` - since WebController is a @Controller, the exception will NOT be caught by ApiExceptionHandler. Instead, we get a default Spring error page.

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
