# Secured endpoints

## MySQL setup

Create the database user.

```sql
DROP USER if exists 'springstudent'@'%' ;
CREATE USER 'springstudent'@'%' IDENTIFIED BY '12345678';
GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'%';
```

Create the database and table.

```sql
CREATE DATABASE IF NOT EXISTS `employee_directory`;
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

Created the JDBC required tables and columns so Spring can get the data it needs.

```sql
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- decrypted password is: 12345678
INSERT INTO `users`
VALUES
('iva','{bcrypt}$2a$10$aFlbLL1UgKvJiYsXJPGnPO3fJfNbwnZomdSg.Sy7YcYOtrxNsGiGO',1),
('miro','{bcrypt}$2a$10$aFlbLL1UgKvJiYsXJPGnPO3fJfNbwnZomdSg.Sy7YcYOtrxNsGiGO',1),
('eli','{bcrypt}$2a$10$aFlbLL1UgKvJiYsXJPGnPO3fJfNbwnZomdSg.Sy7YcYOtrxNsGiGO',1);

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `authorities`
VALUES
('iva','ROLE_EMPLOYEE'),
('miro','ROLE_EMPLOYEE'),
('eli','ROLE_EMPLOYEE'),
('miro','ROLE_MANAGER'),
('eli','ROLE_MANAGER'),
('eli','ROLE_ADMIN');
```

## User credentials

If testing with Postman, from the Authorization tab select _Basic Auth_ and provide username and password. The password for all users is `12345678`

## Project configs

Here is a list of how this project was configured in the Spring Initializr

- Project: Maven
- Language: Java
- Spring Boot: 3.3.0
- Project Metadata:
  - Group: com.example
  - Artifact: mysecuredapp
  - Name: mysecuredapp
  - Description: Demo project for Spring Boot
  - Package Name: com.example.mysecuredapp
  - Packaging: JAR
  - Java: 22
- Dependencies:
  - Spring Web
  - Spring Boot DevTools
  - Spring Data JPA
  - MySQL Driver
  - Spring Security
