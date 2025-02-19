# Spring Framework

The Spring Framework is a powerful, feature-rich framework for building Java applications, particularly for enterprise-level development. It provides comprehensive infrastructure support for developing Java applications and is widely used for building web applications, microservices, and enterprise applications.

Read [here](https://docs.spring.io/spring-framework/reference/index.html) for the official docs.

## Key features of Spring Framework

1. **Inversion of Control (IoC)** – Uses Dependency Injection (DI) to manage object creation and dependencies.
2. **Aspect-Oriented Programming (AOP)** – Supports modularizing cross-cutting concerns like logging, security, and transactions.
3. **Spring MVC** – A robust framework for developing web applications using the Model-View-Controller (MVC) pattern.
4. **Spring Boot** – Simplifies Spring application development with auto-configuration and embedded servers.
5. **Spring Security** – Provides authentication, authorization, and security mechanisms.
6. **Spring Data** – Simplifies data access with JPA, Hibernate, and NoSQL database support.
7. **Spring Cloud** – Helps in building cloud-native, microservices-based architectures.
8. **Transaction Management** – Abstracts different transaction management APIs (JTA, JDBC, Hibernate).
9. **Integration Support** – Works well with messaging, batch processing, and external APIs.

## Advantages of Spring Framework

- **Modular Architecture** – Components can be used independently or together.
- **Lightweight and Fast** – Compared to heavy JEE applications.
- **Testability** – Built-in testing support with JUnit and Mockito.
- **Community and Documentation** – Large community support and extensive documentation.

## Spring and/.vs Jakarta EE

Spring was created to solve the pain points of Jakarta EE (formerly Java EE) by making enterprise Java simpler, lighter, and more flexible. But instead of reinventing everything from scratch, the Spring creators kept the good parts of Jakarta EE (like JPA, Servlets, and JTA) and replaced the parts they thought were too complex (like EJB and CDI).

Now, Jakarta EE is trying to modernize and compete with Spring, but the difference is:

- Spring reused Jakarta EE’s useful APIs and made its own ecosystem.
- Jakarta EE is not reusing Spring’s innovations but instead trying to catch up with similar features.

### Final takeaway

- **Spring depends on Jakarta EE** for certain core APIs but **does not use the full Jakarta EE stack**.
- **Spring competes with Jakarta EE** by offering **better alternatives** for many enterprise features.
- **Jakarta EE is trying to modernize** to win back developers, but Spring is already the go-to choice for cloud and microservices.

## Spring Core

1. **Spring Framework (The Whole Ecosystem)**

- The Spring Framework is the **entire** framework that provides multiple modules for enterprise Java development.
- It includes everything: Spring Core, Spring MVC, Spring Security, Spring Data, Spring AOP, Spring Boot, and more.
- Think of it as the umbrella that covers all Spring-related technologies.

📌 Example Components in Spring Framework:
✔ Spring Core (Dependency Injection)
✔ Spring MVC (Web Framework)
✔ Spring Security (Authentication & Authorization)
✔ Spring Data (Database Access)
✔ Spring AOP (Aspect-Oriented Programming)
✔ Spring Batch, Spring Cloud, etc.

2. **Spring Core (The Heart of Spring)**

- Spring Core is just one part of the Spring Framework.
- It provides the fundamental features like Dependency Injection (DI) and Inversion of Control (IoC).
- Without Spring Core, the rest of the Spring Framework wouldn’t function because it manages the creation and lifecycle of Spring Beans.

📌 Key Components of Spring Core:
✔ ApplicationContext – The container that manages beans.
✔ BeanFactory – A lightweight container for bean management.
✔ Dependency Injection (DI) – The mechanism that enables loose coupling.

### How They Relate

- Spring Core is the foundation of the Spring Framework.
- If you use Spring MVC, Spring Security, or Spring Boot, they all depend on Spring Core for their internal workings.
- You can use Spring Core by itself (without Spring MVC, Spring Security, etc.), but you cannot use Spring Framework without Spring Core.

💡 **Analogy**:

- **Spring Core** is like the **engine of a car**. 🚗
- **Spring Framework** is **the entire car**, which includes the engine (Spring Core), wheels (Spring MVC), security system (Spring Security), and more.

## Content

Recommended learning order for this section:

1. Maven
2. IoCandDI
3. Beans
4. AOP
