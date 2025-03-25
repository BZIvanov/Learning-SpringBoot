# Spring Actuator

## Spring Boot Admin

**Codecentric's Spring Boot Admin** is a powerful tool for monitoring and managing Spring Boot applications by displaying **Actuator endpoints** in a user-friendly web UI. It consists of two main components:

1. **Spring Boot Admin Server**
   - Acts as a centralized dashboard that gathers and displays monitoring data from multiple Spring Boot applications.
   - Provides real-time health checks, metrics, logging, and more in a web UI.
   - Requires `@EnableAdminServer` in the main application class.
2. **Spring Boot Admin Client**
   - Registers individual Spring Boot applications with the **Admin Server** for monitoring.
   - Automatically exposes **Actuator endpoints** (e.g., /health, /metrics).
   - Requires configuring `spring.boot.admin.client.url` in `application.properties` to connect to the Admin Server.

## Content

Recommended learning order for this section:

1. BasicActuator
