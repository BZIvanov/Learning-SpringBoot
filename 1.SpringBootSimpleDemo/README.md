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

## IntelliJ IDEA

If you are using IntelliJ IDE, open the root folder (the one with the pom.xml file) of the project with IntelliJ.

To run the project right-click the class file in `src/main/java/MycoolappApplication` and choose Run MycoolappApplication.

After you start you project, you can visit `http://localhost:8080` to test your application. The default port is 8080. On the page you should see title 'Whitelabel Error Page', because we don't have any endpoints and controllers yet.
