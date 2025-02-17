# Register bean dynamically

In Spring, we can **dynamically register beans at runtime** using the `registerBean()` method from `GenericApplicationContext`. This is useful when you need to create beans dynamically based on conditions, such as reading configurations from a database or environment.

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.2
- Dependencies:
  - Spring Web
