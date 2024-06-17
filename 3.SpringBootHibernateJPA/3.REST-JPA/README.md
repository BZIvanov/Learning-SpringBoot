# Spring Boot REST JPA

In this example we replaced all the boilerplate code with rest dependency and we can still apply all the CRUD operations on the Employee entity.

GET on `http://localhost:8080/api/employees` will return the list with employees. Similarly for the rest of the crud operations.

## MySQL setup

Check the previous demo on how to setup the database.

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
  - Rest Repositories
  - Spring Boot DevTools
  - Spring Data JPA
  - MySQL Driver
