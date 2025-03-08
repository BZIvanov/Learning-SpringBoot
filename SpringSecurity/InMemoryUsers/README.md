# InMemory users demo

## Playing with the demo

- **GET** `http://localhost:8080` - public endpoint, no authentication required
- **GET** `http://localhost:8080/user` - protected endpoint for users with role _user_
- **GET** `http://localhost:8080/admin` - protected endpoint for users with role _admin_

For the protected endpoints, you will have to use **Basic Auth**, if testing with Postman. The password for all users is _12345_ and you can find the username in _SecurityConfig_ class.

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
  - Spring Security
