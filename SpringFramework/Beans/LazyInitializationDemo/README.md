# Lazy initialization demo

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.2
- Dependencies:
  - Spring Web

### @Lazy annotation

`@Lazy` annotation is used to indicate that a bean should be lazily initialized. This means that the bean will not be created and initialized until it is actually needed.

By default, Spring creates and initializes all singleton beans eagerly when the application context is started. You can change this behavior by marking a specific bean with the `@Lazy` annotation.

We can also apply the lazy globally.
