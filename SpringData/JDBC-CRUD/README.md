# JDBC CRUD demo

This demo shows how to use `JdbcTemplate` for CRUD operations.

## Preparing the database

Run the below sql queries to create the database, the table and the database user:

```sql
DROP DATABASE IF EXISTS `company`;
CREATE DATABASE `company`;
USE `company`;

DROP USER IF EXISTS 'springstudent'@'%' ;
CREATE USER 'springstudent'@'%' IDENTIFIED BY '12345678';
GRANT ALL PRIVILEGES ON company.* TO 'springstudent'@'%';
FLUSH PRIVILEGES;
-- verify the user was created
SELECT user, host FROM mysql.user;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100),
    salary DOUBLE
);
```

## Demo endpoints

- POST `http://localhost:8080/employees`
  ```json
  {
    "name": "John Doe",
    "department": "IT",
    "salary": 50000
  }
  ```
- GET `http://localhost:8080/employees`
- GET `http://localhost:8080/employees/1`
- PUT `http://localhost:8080/employees/1`
  ```json
  {
    "name": "John Smith",
    "department": "HR",
    "salary": 55000
  }
  ```
- DELETE `http://localhost:8080/employees/1`

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 24
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
  - Spring Data JDBC
  - MySQL Driver
