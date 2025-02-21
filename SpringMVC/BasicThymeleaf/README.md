# Basic thymeleaf demo

Using `WebMvcConfigurer` simplifies static page mapping and removes unnecessary controllers, making your Spring Boot app cleaner and more efficient. For `home` page, we are still using custom controller, because we are also providing dynamic data.

## Spring Boot Devtools dependency

**spring-boot-devtools** allow us to automatically restart the application and apply the code changes.

### Devtools with IntelliJ

If using IntelliJ, it requires to be allowed in **Advanced settings** > **Compiler** > **Allow auto-make to start...**. And also check the checkbox in **Build,Execution,Deployment** > **Compiler** > **Build project automatically**.

Note that it still might take few seconds for the server to restart and to see the changes.

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
  - Spring Boot Dev Tools
  - Thymeleaf
