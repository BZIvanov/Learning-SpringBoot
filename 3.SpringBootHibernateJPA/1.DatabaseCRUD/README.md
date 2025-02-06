# Spring Boot Hibernate CRUD

Hibernate demo for connect Spring Boot to MySQL database. There are no REST functionality with actual endpoints in this demo, just CRUD methods. In the boot class you can test with by commenting/uncommenting them.

## MySQL connection prerequisite

Based on the `application.properties` file before using this demo you will have to create database user with username: _springstudent_ and password: _12345678_ also database called _student_tracker_. The table will be autotmatically dropped and recreated everytime you run the application, this is because of the config `spring.jpa.hibernate.ddl-auto=create` specified again in `application.properties` file, if you want to keep the data, either use different value or comment the line.

## @GeneratedValue

### Strategy types

- **AUTO** - JPA decides the generation strategy based on the database provider. Usually uses **IDENTITY** or **SEQUENCE**.
- **IDENTITY** - Uses the **database’s auto-increment** feature (e.g., MySQL’s `AUTO_INCREMENT`, PostgreSQL’s `SERIAL`). The database generates the ID when inserting a row.
- **SEQUENCE** - Uses a **database sequence** (recommended for PostgreSQL, Oracle). JPA generates IDs using a separate sequence object. Requires defining a sequence using `@SequenceGenerator`.
- **TABLE** - Stores and maintains ID values in a **database table**. Rarely used due to performance overhead.

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
