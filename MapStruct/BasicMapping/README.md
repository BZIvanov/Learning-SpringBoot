# Basic Mapping demo

This demo showcases how to integrate **MapStruct v1.6.3** with **Spring Boot** to perform automatic mapping between DTOs and entities. It includes:

- A `User` entity and its corresponding `UserDTO`.
- A `UserMapper` interface using MapStruct for object conversion.
- A `UserService` for handling business logic.
- A `UserController` that exposes REST API endpoints with `ResponseEntity<>` for flexible HTTP responses.

**Features:**

- Uses **MapStruct** for compile-time DTO mapping.
- Implements **Spring Boot REST API** with `ResponseEntity<>` for customizable status codes.
- Includes **JPA Repository** for database interactions.

## Setting up the database

Run the below SQL queries to setup the database:

```sql
DROP DATABASE IF EXISTS `blog_db`;
CREATE DATABASE `blog_db`;
USE `blog_db`;

DROP USER IF EXISTS 'springstudent'@'%' ;
CREATE USER 'springstudent'@'%' IDENTIFIED BY '12345678';
GRANT ALL PRIVILEGES ON blog_db.* TO 'springstudent'@'%';
FLUSH PRIVILEGES;
-- verify the user was created
SELECT user, host FROM mysql.user;
```

## Testing the demo

Using **Postman** you can run the below queries to test the demo:

- **Create user**:

  ```bash
  POST http://localhost:8080/users
  Content-Type: application/json

  {
    "name": "John Doe",
    "email": "john.doe@example.com"
  }
  ```

- **Get users**:
  ```bash
  GET http://localhost:8080/users
  ```

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.4
- Dependencies:
  - Spring Web
  - Lombok
  - Spring Data JPA
  - MySQL Driver
