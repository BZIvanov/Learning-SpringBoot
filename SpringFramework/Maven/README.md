# Maven

Maven is a build automation and project management tool used primarily for Java projects, including Spring Boot applications. Maven helps manage project dependencies, compile and package the application, and handle other tasks such as running tests and deploying the application.

Maven is similar to NPM for Node.js. They both serve similar purposes in their respective ecosystems, managing dependencies, automating tasks, and maintaining project configurations to streamline the development process.

Click [here](https://maven.apache.org/) for Maven web page.

## Maven and IntelliJ

On the right-hand side vertical menu you can see the Maven icon.

You have ready to use actions, for example _Maven > project-name-here > Lifecycle > clean_.

## Starting new Spring project

When creating a new Spring-based project, we have two main options:

1. **Manual Setup (For General Spring Projects)**

   - Use Maven or Gradle manually.
   - Add Spring dependencies manually (e.g., Spring Core, Spring MVC, JPA, etc.).
   - Manually configure an application server (e.g., Tomcat, WildFly).
   - Manually define XML or Java-based configurations (no Spring Boot auto-configuration).
   - More flexible but requires more effort to set up.

   **Best for**:

   - Large, enterprise projects with custom configurations.
   - Applications that need to integrate with Jakarta EE or legacy systems.
   - When you don’t want to use Spring Boot’s auto-configuration.

2. **Spring Boot Setup (Using Spring Initializr)**

   - Uses Spring Initializr for quick project generation.
   - Spring Boot auto-configuration (no need to configure the server, dependency management, etc.).
   - Comes with embedded Tomcat, Jetty, or Undertow (no external server required).
   - Uses `@SpringBootApplication`, auto-configured beans, and application properties.
   - Faster and easier to start a project.

   **Best for**:

   - Microservices and cloud-based applications.
   - Rapid development with minimal configuration.
   - When you want an easy, production-ready setup with Spring Boot features.

---

For the examples here, we will use Spring Initializr

Visit this [link](https://start.spring.io/) to configure your new project and download the starter files as a zip from where you can continue building your project.

## Dependencies

We can select our dependencies in the spring initializr, when configuring our project. We can also add them manually later, we will also have to restart the project.

### Dependencies with IntelliJ

If you are using IntelliJ and adding manually dependencies, you can click the small maven icon, which will appear so maven can install them and add them to our project.
