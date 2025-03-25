# Basic security demo

Secured project, which require the user to login with generic username and auto generated password.

## Credentials for this demo

Visit `http://localhost:8080`. You will be redirected to login. Your username is `user` and you can find your password in the app console after starting the application.

After you login, you can logout by visiting `http://localhost:8080/logout`.

## Configuring custom spring security credentials

In case you don't want to use the defaul `user` username and the auto generated password from the console, you can provide in `application.properties` your custom username and password like shown below:

```
# custom username and password
spring.security.user.name=john
spring.security.user.password=12345
```

This is useful for easy login while learning Spring Security. Of course in real world, we don't provide all our users with credentials from our `application.properties` file.

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
  - Spring Security
