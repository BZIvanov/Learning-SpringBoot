# Spring Boot REST

Example of simple CRUD endpoints with MySQL.

This example contains a lot of boilerplate code for creating all the crud operations. For example, if we want to add more entities (except the employee), we would have to copy paste a lot of code and just change the entity name. In the next demo, we will see example how all that can be replaced with the rest dependency, which creates all the endpoints and controllers based on the provided Entity.

## MySQL setup

To test this demo you need to create user, database and table. Use the below SQL queries to prepare the database.

You can use any Workbench connection. For example the default Workbench connection with the root user.

```sql
CREATE DATABASE IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

DROP USER if exists 'springstudent'@'%' ;
CREATE USER 'springstudent'@'%' IDENTIFIED BY '12345678';
GRANT ALL PRIVILEGES ON employee_directory.* TO 'springstudent'@'%';
FLUSH PRIVILEGES;
-- verify the user was created
SELECT user, host FROM mysql.user;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `employee` VALUES
	(1,'John','Doe','john@mail.com'),
	(2,'Jane','Doe','jane@mail.com'),
	(3,'Alice','Alis','alice@mail.com');

SELECT * FROM employee;
```

## Project configs

Here is a list of how this project was configured in the Spring Initializr

- Project: Maven
- Language: Java
- Spring Boot: 3.3.0
- Project Metadata:
  - Group: com.example
  - Artifact: myrestapp
  - Name: myrestapp
  - Description: Demo project for Spring Boot
  - Package Name: com.example.myrestapp
  - Packaging: JAR
  - Java: 22
- Dependencies:
  - Spring Web
  - Spring Boot DevTools
  - Spring Data JPA
  - MySQL Driver
