# Pagination and sorting with custom values demo

## Database genetation

Use the below code to generate your database and the database user.

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
```

Run the below query to feed some testing data:

```sql
INSERT INTO employees (name, department, salary) VALUES
('Alice Johnson', 'IT', 75000),
('Bob Smith', 'HR', 60000),
('Charlie Brown', 'Finance', 80000),
('David Wilson', 'IT', 90000),
('Emma Davis', 'HR', 58000),
('Frank Thomas', 'Marketing', 72000),
('Grace Lee', 'Finance', 95000),
('Henry White', 'Marketing', 70000),
('Isabella Adams', 'IT', 85000),
('Jack Harris', 'HR', 62000);
```

## Demo endpoints

List with endpoints for this demo:

- GET `http://localhost:8080/api/employees?page=0&size=5&sortBy=salary&direction=desc`
- GET `http://localhost:8080/api/employees/department/IT?page=0&size=5`

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
