# Spring Boot additional dependencies demo

In this folder there is basic demo project with some additional dependencies.

## Dependencies

- spring-boot-devtools - allow us to automatically restart the application and apply the code changes. If using IntelliJ, it requires changes on the settings.
- spring-boot-starter-actuator - providing us with some additional endpoints. For example `http://localhost:8080/actuator/health`.
- spring-boot-starter-security - adding security to our application. To access the endpoints you will have to login, the credentials are `user` as username and you can find the password in the console after starting the application.

## Project configs

Here is a list of how this project was configured in the Spring Initializr

- Project: Maven
- Language: Java
- Spring Boot: 3.3.0
- Project Metadata:
  - Group: com.example
  - Artifact: mycoolapp
  - Name: mycoolapp
  - Description: Demo project for Spring Boot
  - Package Name: com.example.mycoolapp
  - Packaging: JAR
  - Java: 22
- Dependencies:
  - Spring Web
