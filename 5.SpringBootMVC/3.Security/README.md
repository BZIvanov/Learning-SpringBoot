# MVC Security

## MySQL setup

Create the database user.

```sql
DROP USER if exists 'springstudent'@'%' ;

CREATE USER 'springstudent'@'%' IDENTIFIED BY '12345678';

GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'%';
```

Create the database and table.

```sql
DROP DATABASE `employee_directory`;

CREATE DATABASE IF NOT EXISTS `employee_directory`;

USE `employee_directory`;
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

## Project configs

Here is a list of how this project was configured in the Spring Initializr

- Project: Maven
- Language: Java
- Spring Boot: 3.3.1
- Project Metadata:
  - Group: com.example
  - Artifact: mvcdemo
  - Name: mvcdemo
  - Description: Demo project for Spring Boot
  - Package Name: com.example.mvcdemo
  - Packaging: JAR
  - Java: 22
- Dependencies:
  - Spring Web
  - Spring Boot DevTools
  - Thymeleaf
  - Spring Security
  - Spring Data JPA
  - MySQL Driver
