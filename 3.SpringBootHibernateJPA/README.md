## JDBC

JDBC (Java Database Connectivity) is a low-level API that allows a Spring Boot application to connect to a relational database and execute SQL queries. Spring Boot provides `JdbcTemplate` to simplify JDBC operations and uses **HikariCP** as the default connection pool for performance optimization.

Use JDBC when you need full control over SQL queries, batch processing, or better performance for complex queries.

## JPA

Jakarta Persistence API (JPA) is a specification for managing relational data in Java applications. It provides an abstraction for **object-relational mapping (ORM)**, enabling developers to map Java objects to database tables. JPA itself is just a standard and requires an implementation like **Hibernate**.

In Spring Boot, `spring-boot-starter-data-jpa` simplifies database interactions by integrating JPA with Spring’s infrastructure, allowing developers to perform database operations using repository interfaces and JPQL (Java Persistence Query Language).

### Can We Skip JPA and Hibernate?

Yes, a Spring Boot application can work entirely with JDBC without JPA or Hibernate. However:

- You would need to manually handle SQL queries, connection management, and transaction handling.
- No automatic entity mapping—you must convert query results to objects manually.
- More boilerplate code compared to JPA/Hibernate.

JPA and Hibernate abstract away these complexities, making it easier to work with relational databases in Java applications.

## Hibernate

Hibernate is the most popular **JPA implementation** and an Object-Relational Mapping (ORM) framework. In Spring Boot, Hibernate simplifies the interaction with relational databases by mapping Java classes to database tables.

Key features of Hibernate include:

- **Automatic SQL generation** (reduces boilerplate code).
- **Caching mechanisms** (first-level and second-level caching).
- **Lazy loading and fetching strategies** to optimize performance.
- **Support for JPQL** (Java Persistence Query Language) and native SQL.

Hibernate is included in Spring Boot via `spring-boot-starter-data-jpa` and is the default JPA provider.
