# Pagination and sorting demo

## Database genetation

Use the below code to generate your database and the database user.

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

List with endpoints for this demo:

- GET `http://localhost:8080/api/v1/students?size=20&page=0&sort=learningBudget,desc`
- GET `http://localhost:8080/api/v1/students/1`
- POST `http://localhost:8080/api/v1/students`

  ```json
  {
    "name": "John",
    "semester": 1,
    "learningBudget": 2400.5,
    "examDate": "2026-03-28"
  }
  ```

- PUT `http://localhost:8080/api/v1/students/1`

  ```json
  {
    "semester": 3,
    "learningBudget": 2500.5
  }
  ```

- DELETE `http://localhost:8080/api/v1/students/1`

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
  - Spring Boot DevTools
  - Spring Data JPA
  - MySQL Driver
  - Lombok
