# Spring Boot simple demo

In this folder there is an empty starter project files.

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

## Project structure

#### pom.xml file (Project Object Model)

This pom.xml file is for a Spring Boot project using Maven as the build tool. It defines the basic configuration and dependencies needed for a simple Spring Boot web application.

#### mvnw and mvnw.cmd files (Maven wrapper files)

The mvnw and mvnw.cmd files are part of the Maven Wrapper, a tool that helps ensure a consistent and reproducible build environment.

- mvnw - a shell script for Unix-based systems (like Linux and macOS) that wraps the Maven command. It is used to run Maven commands without requiring Maven to be pre-installed on the system.
- mvnw.cmd - a batch script for Windows systems that serves the same purpose as mvnw, allowing users to run Maven commands without needing to install Maven beforehand.

If we have Maven locally installed, we don't need the above 2 files, but even if you have Maven installed locally, it's generally considered a good practice to include the Maven Wrapper in your project. It provides a safety net and ensures a more reproducible build environment.

#### application.properties file

The application.properties file is used to define configuration properties for the application. These properties can configure various aspects of the application, such as database connection details, server settings, logging levels, and custom application settings.

## IntelliJ IDEA

If you are using IntelliJ IDE, open the root folder (the one with the pom.xml file) of the project with IntelliJ.

To run the project right-click the class file in `src/main/java/MycoolappApplication` and choose Run MycoolappApplication.

After you start you project, you can visit `http://localhost:8080` to test your application. The default port is 8080. On the page you should see title 'Whitelabel Error Page', because we don't have any endpoints and controllers yet.
