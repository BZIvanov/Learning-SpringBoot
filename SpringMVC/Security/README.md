# MVC Security

Visit `http://localhost:8080` and you will be redirected to `http://localhost:8080/login` to login. Check the MySQL scripts below for existing user credentials to login.

## MySQL setup

Create the database and table.

```sql
DROP DATABASE IF EXISTS `employee_directory`;
CREATE DATABASE IF NOT EXISTS `employee_directory`;
USE `employee_directory`;
```

Create the database user.

```sql
DROP USER if exists 'springstudent'@'%' ;
CREATE USER 'springstudent'@'%' IDENTIFIED BY '12345678';
GRANT ALL PRIVILEGES ON employee_directory.* TO 'springstudent'@'%';
FLUSH PRIVILEGES;
-- verify the user was created
SELECT user, host FROM mysql.user;
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

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
  - Spring Boot Dev Tools
  - Thymeleaf
  - Spring Data JPA
  - MySQL Driver
  - Spring Security
