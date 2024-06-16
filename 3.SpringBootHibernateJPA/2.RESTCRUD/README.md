# Spring Boot REST

Example of simple CRUD endpoints with MySQL.

## MySQL setup

To test this demo you need to create user, database and table. Use the below SQL queries to prepare the database.

```sql
DROP USER if exists 'springstudent'@'%' ;

CREATE USER 'springstudent'@'%' IDENTIFIED BY '12345678';

GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'%';

CREATE DATABASE  IF NOT EXISTS `employee_directory`;

USE `employee_directory`;

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
