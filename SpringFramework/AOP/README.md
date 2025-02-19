# Aspect-oriented programming (AOP)

Read the [docs](https://docs.spring.io/spring-framework/reference/core/aop.html).

AOP (Aspect-Oriented Programming) is a programming paradigm in Spring that helps separate cross-cutting concerns (like logging, security, or transaction management) from business logic. It allows us to define reusable aspects that can be applied to multiple parts of the application without modifying existing code.

## Key concepts of AOP

- **Aspect**: A modular unit of cross-cutting concerns.
- **Advice**: The actual code that runs (e.g., `@Before`, `@After`, `@Around`).
- **Join Point**: A point in program execution (e.g., method call) where an aspect is applied.
- **Pointcut**: A condition/predicate that defines where an aspect should be applied.
- **Weaving**: The process of applying aspects to target methods.

## Example: logging with AOP

Here, `@Before` runs before any method in `com.example.service` package is executed.

```java
    @Aspect
    @Component
    public class LoggingAspect {
        @Before("execution(* com.example.service.*.*(..))")
        public void logBefore(JoinPoint joinPoint) {
            System.out.println("Executing: " + joinPoint.getSignature());
        }
    }
```

## Content

Recommended learning order for this section:

1. BeforeAspectDemo
