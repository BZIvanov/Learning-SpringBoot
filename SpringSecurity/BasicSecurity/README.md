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

## Default security configuration

As you can see in this demo, every endpoint in our project **requires authentication by default**.
In the upcoming demos, we will see how to provide our custom configuration, but for this demo, we will explore just the defaults.

### Basic Authentication

Basic Authentication is an HTTP authentication scheme where credentials (**username & password**) are sent in **every request** using the `Authorization` header.

#### How it works in Spring Security (default behavior)

- When a user accesses a protected resource, Spring Security responds with:

```http
HTTP/1.1 401 Unauthorized
WWW-Authenticate: Basic realm="Spring Security"
```

- The browser prompts for credentials.
- The browser encodes `username:password` in **Base64** and sends:

```http
Authorization: Basic dXNlcm5hbWU6cGFzc3dvcmQ=  # Base64("username:password")
```

- Spring Security **decodes & verifies** the credentials.
- If correct, the request is **processed**, otherwise, a `401 Unauthorized` response is returned.

By default, if Spring Security is on the classpath and no explicit configuration is provided, **Basic Authentication is enabled**.

### Form-Based Authentication

Form-Based Authentication provides a **login form** where users enter their username and password, and Spring Security handles authentication using **session-based login**.

#### How it works in Spring Security (default behavior)

- When a user accesses a protected resource, they are redirected to `/login`.
- Spring Security provides a **default login page**.
- The user enters credentials, and the form submits a `POST` request to `/login` with:

```http
POST /login
Content-Type: application/x-www-form-urlencoded

username=user&password=pass
```

- Spring Security validates the credentials.
- If successful:
  - A **session is created**, and the `JSESSIONID` is sent via a cookie:
    ```http
    Set-Cookie: JSESSIONID=ABC123; Path=/; HttpOnly
    ```
  - The user is redirected to the original requested page or `/`.
- For subsequent requests, the **JSESSIONID cookie** is automatically sent by the browser:
  ```http
  Cookie: JSESSIONID=ABC123
  ```
  This maintains the user's session.

### Basic Authentication vs. Form-Based Authentication

- **Browser**: Redirects to `/login` for form-based authentication.
- **Postman/cURL**: Returns `401 Unauthorized` unless `Authorization: Basic ...` is provided.
- **Spring Security automatically selects the authentication method** based on how the request is made.

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
  - Spring Security
