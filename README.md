# Learning Spring Boot

Spring Boot uses Spring behind the scenes and makes configuration work easier.

## About this repository

This repo contains information and example about Java framework Spring Boot. It requires Java knowledge, you check my other repo **Learning-Java** before starting with this one.

## Best practices to scale Spring Boot apps

1. Use a Clean Modular Architecture
   - Follow Domain-Driven Design (DDD) and Hexagonal Architecture (or Clean Architecture).
   - Split your application into modules:
     - `application` (controllers, services, etc.)
     - `domain` (business logic, entities)
     - `infrastructure` (database, external APIs, configurations)
2. Avoid overusing `@Autowired`
   - Use constructor injection instead of @Autowired, as it's easier to test and maintain.
3. Define Clear Layered Architecture
   - **Controller Layer** → Handles HTTP requests
   - **Service Layer** → Business logic
   - **Repository Layer** → Database operations
4. Use Profiles for Configuration Management
   - Define separate profiles (dev, test, prod) using application-{profile}.yml.
5. Implement Caching & Database Optimization
   - Use Spring Cache (@Cacheable) to reduce redundant calls.
   - Optimize database queries with pagination and indexing.
6. Enable Proper Logging & Monitoring
   - Use Spring Boot Actuator for metrics.
   - Implement structured logging (e.g., ELK stack or Prometheus + Grafana).
7. Write Unit & Integration Tests
