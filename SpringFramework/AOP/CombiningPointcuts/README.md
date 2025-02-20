# Combining pointcuts demo

## Recommendation

**Avoid placing all types of files in the same package as those targeted by aspects. In this demo, for example, the `DemoRunner` class should be kept outside the `school` package. This prevents the aspect from unintentionally matching methods in `DemoRunner`, which could lead to unexpected behavior. In other words, files responsible for running the project should be separate from those affected by AOP logic.**

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.2
- Dependencies:
  - Spring Web
