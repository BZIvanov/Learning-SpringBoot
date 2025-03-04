# Spring Data

## JDBC

JDBC (Java Database Connectivity) is a low-level API that allows a Spring Boot application to connect to a relational database and execute SQL queries. Spring Boot provides `JdbcTemplate` to simplify JDBC operations and uses **HikariCP** as the default connection pool for performance optimization.

Use JDBC when you need full control over SQL queries, batch processing, or better performance for complex queries.

## JPA

Jakarta Persistence API (JPA) is a specification for managing relational data in Java applications. It provides an abstraction for **object-relational mapping (ORM)**, enabling developers to map Java objects to database tables. JPA itself is just a standard and requires an implementation like **Hibernate**.

In Spring Boot, `spring-boot-starter-data-jpa` simplifies database interactions by integrating JPA with Spring’s infrastructure, allowing developers to perform database operations using repository interfaces and JPQL (Java Persistence Query Language).

### JPQL

JPQL (Java Persistence Query Language) is an object-oriented query language designed for JPA.

#### Why do we need JPQL if we have JDBC?

- it works with JPA entities, not sql tables
- more readable and maintainable
- supports automatic mapping
- database independence
- can be used in native queries

### Can We Skip JPA and Hibernate?

Yes, a Spring Boot application can work entirely with JDBC without JPA or Hibernate. However:

- You would need to manually handle SQL queries, connection management, and transaction handling.
- No automatic entity mapping—you must convert query results to objects manually.
- More boilerplate code compared to JPA/Hibernate.

JPA and Hibernate abstract away these complexities, making it easier to work with relational databases in Java applications.

### When to Use JPQL vs. JDBC?

| Use Case                                             | JPQL               | JDBC (`JdbcTemplate`)            |
| ---------------------------------------------------- | ------------------ | -------------------------------- |
| **Simple CRUD Operations**                           | ✅ Yes             | ❌ No need, JPA handles it       |
| **Queries with Entity Relationships (`JOIN FETCH`)** | ✅ Yes             | ⚠️ Requires complex SQL joins    |
| **Complex Aggregations, Bulk Inserts/Updates**       | ⚠️ Limited support | ✅ Best suited                   |
| **Stored Procedures, Vendor-Specific SQL**           | ❌ No              | ✅ Best suited                   |
| **Read-Only, Performance-Optimized Queries**         | ❌ Not ideal       | ✅ Better for performance tuning |

## Hibernate

Hibernate is the most popular **JPA implementation** and an Object-Relational Mapping (ORM) framework. In Spring Boot, Hibernate simplifies the interaction with relational databases by mapping Java classes to database tables.

Key features of Hibernate include:

- **Automatic SQL generation** (reduces boilerplate code).
- **Caching mechanisms** (first-level and second-level caching).
- **Lazy loading and fetching strategies** to optimize performance.
- **Support for JPQL** (Java Persistence Query Language) and native SQL.

Hibernate is included in Spring Boot via `spring-boot-starter-data-jpa` and is the default JPA provider.

## Hierarchy of choosing database access in Spring Boot

1. **Use JPA repository methods (ready-to-use queries) first**
   - If your query is simple, like `findById()`, `findAll()`, or `findByName()`, use Spring Data JPA’s built-in methods.
   - Example
   ```java
       List<User> findByStatus(String status);
   ```
   - Why? Less code, more abstraction, and database-agnostic.
2. **Use JPQL for more custom queries**
   - If JPA doesn’t provide what you need, use JPQL to query entities using object-oriented syntax.
   - Example (JPQL query inside a repository method):
   ```java
       @Query("SELECT u FROM User u WHERE u.status = :status AND u.role = :role")
       List<User> fetchByStatusAndRole(@Param("status") String status, @Param("role") String role);
   ```
   - Why? Still abstracted from the raw SQL syntax, but allows more flexibility than JPA.
3. **Use JDBC for raw SQL & performance optimization**
   - If JPQL can’t handle it (e.g., bulk inserts, complex joins, stored procedures, or vendor-specific queries), then go for JDBC (`JdbcTemplate`).
   - Example (using JdbcTemplate for batch inserts)
   ```java
       jdbcTemplate.batchUpdate("INSERT INTO users (name, email) VALUES (?, ?)", userList);
   ```
   - Why? JDBC gives you full control over SQL but requires more manual coding.

## CascadeType options

[Read here](https://jakarta.ee/specifications/persistence/2.2/apidocs/javax/persistence/cascadetype) for the official docs. Note that it is the Jakarta documentation, not on the Spring Boot documentation.

## Content

Recommended learning order for this section:

1. EntityManager-CRUD
2. JPA-CRUD
3. H2Database
4. JPAQueryMethods
5. JPQLQueries
6. PaginationAndSorting
7. Relations
