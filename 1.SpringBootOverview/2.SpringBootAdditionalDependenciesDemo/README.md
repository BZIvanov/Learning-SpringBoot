# Spring Boot additional dependencies demo

In this folder there is basic demo project with some additional dependencies.

## Dependencies

In this example we have manually added the below dependencies just for the demo. In real use case you can add them in the Sprint initializr. If you are manually adding dependencies you will have to restart the application.

- **spring-boot-devtools** - allow us to automatically restart the application and apply the code changes. If using IntelliJ, it requires changes on the settings.
- **spring-boot-starter-actuator** - providing us with some additional endpoints. For example `http://localhost:8080/actuator`.
- **spring-boot-starter-security** - adding security to our application. To access the endpoints you will have to login, the credentials are `user` as username and you can find the password in the console after starting the application.

## Custom endpoints

- `http://localhost:8080` - will return "Hello World"
- `http://localhost:8080/employee` - will return "Iva lives in Sofia" based on the provided values

## Server port

If we provide `0` as port number, a random number will be provided as a port.

## Project configs

Here is a list of how this project was configured in the Spring Initializr

- Project: Maven
- Language: Java
- Spring Boot: 3.4.2
- Project Metadata:
  - Group: com.example
  - Artifact: mycoolapp
  - Name: mycoolapp
  - Description: Demo project for Spring Boot
  - Package Name: com.example.mycoolapp
  - Packaging: JAR
  - Java: 23
- Dependencies:
  - Spring Web
