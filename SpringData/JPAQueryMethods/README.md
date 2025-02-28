# JPA Query Methods

Read [here](https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html) the official docs for more info.

This demo shows how Spring Data JPA automatically generates queries from method names. No need to write custom SQL queries. Works seamlessly with Spring Boot & MySQL.

## MySQL setup

The the below sql to setup the database and the database user.

```sql
DROP DATABASE IF EXISTS `school`;
CREATE DATABASE `school`;
USE `school`;

DROP USER IF EXISTS 'springstudent'@'%' ;
CREATE USER 'springstudent'@'%' IDENTIFIED BY '12345678';
GRANT ALL PRIVILEGES ON school.* TO 'springstudent'@'%';
FLUSH PRIVILEGES;
-- verify the user was created
SELECT user, host FROM mysql.user;
```

## Demo endpoints

### POST example endpoints for creating some test data

- POST `http://localhost:8080/api/students`
  ```json
  {
    "firstName": "John",
    "lastName": "Doe",
    "email": "john@example.com",
    "age": 28
  }
  ```
  ```json
  {
    "firstName": "Alice",
    "lastName": "Smith",
    "email": "alice@example.com",
    "age": 35
  }
  ```

### GET example endpoints

- GET `http://localhost:8080/api/students`
- GET `http://localhost:8080/api/students/firstName/John`
- GET `http://localhost:8080/api/students/email/john@example.com`
- GET `http://localhost:8080/api/students/olderThan/30`

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
  - Spring Data JPA
  - MySQL Driver
  - Lombok
