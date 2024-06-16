# Spring Boot Hibernate CRUD

Hibernate demo for connect Spring Boot to MySQL database. There are no REST functionality with actual endpoints in this demo, just CRUD methods. In the boot class you can test with by commenting/uncommenting them.

## MySQL connection prerequisite

Based on the `application.properties` file before using this demo you will have to create database user with username: _springstudent_ and password: _12345678_ also database called _student_tracker_. The table will be autotmatically dropped and recreated everytime you run the application, this is because of the config `spring.jpa.hibernate.ddl-auto=create` specified again in `application.properties` file, if you want to keep the data, either use different value or comment the line.

## Project configs

Here is a list of how this project was configured in the Spring Initializr

- Project: Maven
- Language: Java
- Spring Boot: 3.3.0
- Project Metadata:
  - Group: com.example
  - Artifact: mycrudapp
  - Name: mycrudapp
  - Description: Demo project for Spring Boot
  - Package Name: com.example.mycrudapp
  - Packaging: JAR
  - Java: 22
- Dependencies:
  - MySQL Driver
  - Spring Data JPA
