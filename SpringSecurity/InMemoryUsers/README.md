# InMemory users demo

## Playing with the demo

- **GET** `http://localhost:8080` - public endpoint, no authentication required
- **GET** `http://localhost:8080/user` - protected endpoint for users with role _user_
- **GET** `http://localhost:8080/admin` - protected endpoint for users with role _admin_

For the protected endpoints, you will have to use **Basic Auth**, if testing with Postman. The password for all users is _12345_ and you can find the username in _SecurityConfig_ class.

## Users management in Spring Security

### `UserDetails`

`UserDetails` is an **interface** in Spring Security that represents the **authenticated user’s data**. Spring Security uses this to retrieve and verify user credentials.

### `User`

`User` is a **built-in class** in Spring Security that **implements** `UserDetails`. It provides an easy way to create user objects for authentication.

It is commonly used in **in-memory authentication**. It helps define **username, password, and roles** without creating a custom UserDetails class.

### `UserDetailsService`

`UserDetailsService` is an interface that defines how Spring Security loads user details. It fetches a user by username from **memory, a database, or another source**.

### `UserDetailsManager`

`UserDetailsManager` is an extension of `UserDetailsService` that provides **user management methods**. It allows adding, updating, or deleting users.

### Quick Analogy

Think of it like a **library system**:

- `UserDetails` = A **library card** (holds user details).
- `UserDetailsService` = The **librarian** (finds user info but can’t change it).
- `UserDetailsManager` = The **library admin** (can create, update, or remove users).

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
  - Spring Security
