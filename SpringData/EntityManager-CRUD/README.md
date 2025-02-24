# Entity manager demo

This demo contains a lot of boilerplate code for creating all the crud operations. For example, if we want to add more entities (except the employee), we would have to copy paste a lot of code and just change the entity name. In the next demo, we will see example how all that can be replaced with JPA, which creates all the endpoints and controllers based on the provided Entity.

## MySQL connection prerequisite

Based on the `application.properties` file before using this demo you will have to create database user with username: _springstudent_ and password: _12345678_ also database called _student_tracker_.

You can use any Workbench connection. For example the default Workbench connection with the root user.

Below is ready to use sql:

```sql
DROP DATABASE IF EXISTS `student_tracker`;
CREATE DATABASE IF NOT EXISTS `student_tracker`;
USE `student_tracker`;

DROP USER if exists 'springstudent'@'%' ;
CREATE USER 'springstudent'@'%' IDENTIFIED BY '12345678';
GRANT ALL PRIVILEGES ON student_tracker.* TO 'springstudent'@'%';
FLUSH PRIVILEGES;
-- verify the user was created
SELECT user, host FROM mysql.user;
```

## Demo endpoints

- GET `http://localhost:8080/api/students`
- GET `http://localhost:8080/api/students/1`
- POST `http://localhost:8080/api/students`
  ```json
  {
    "firstName": "John",
    "lastName": "Doe",
    "email": "john@mail.com"
  }
  ```
- PUT `http://localhost:8080/api/students/1`
  ```json
  {
    "firstName": "Jake",
    "lastName": "Doe",
    "email": "jake@mail.com"
  }
  ```
- DELETE `http://localhost:8080/api/students/1`

## @GeneratedValue

### Strategy types

- **AUTO** - JPA decides the generation strategy based on the database provider. Usually uses **IDENTITY** or **SEQUENCE**.
- **IDENTITY** - Uses the **database’s auto-increment** feature (e.g., MySQL’s `AUTO_INCREMENT`, PostgreSQL’s `SERIAL`). The database generates the ID when inserting a row.
- **SEQUENCE** - Uses a **database sequence** (recommended for PostgreSQL, Oracle). JPA generates IDs using a separate sequence object. Requires defining a sequence using `@SequenceGenerator`.
- **TABLE** - Stores and maintains ID values in a **database table**. Rarely used due to performance overhead.

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
  - Spring Data JPA
  - MySQL Driver
