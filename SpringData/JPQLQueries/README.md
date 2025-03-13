# JPQL Queries demo

## Preparing the database

Run the below sql queries to create the database and the database user:

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

## Playing with the demo

- POST `http://localhost:8080/api/students`
  ```json
  {
    "name": "Alice",
    "email": "alice@example.com",
    "age": 23
  }
  ```
- PUT `http://localhost:8080/api/students/1`
  ```json
  {
    "name": "Alice",
    "email": "alice@example.com",
    "age": 24
  }
  ```
- GET `http://localhost:8080/api/students/name/Alice`
- GET `http://localhost:8080/api/students/older-than/23`
- GET `http://localhost:8080/api/students/email/ice`
- DELETE `http://localhost:8080/api/students/name/Alice`

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
