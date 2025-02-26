# Web scopes demo

## Playing with the demo

Run the Spring Boot application and test the endpoints using Postman or a browser.

1. Testing `@RequestScope` - Open `http://localhost:8080/scope/request`
   - Each request gets a new instance, so the count always resets to 1.
   - Output (always 1 on new request)
2. Testing `@SessionScope` - Open `http://localhost:8080/scope/session`
   - The count persists for the same user session.
   - Opening a new browser session or clearing cookies will reset the count.
   - Output (increments with each request)
3. Testing `@ApplicationScope` - Open `http://localhost:8080/scope/application`
   - The count is shared across all users and persists until the app restarts. You could also test by opening the endpoint from different browsers.
   - Output (increments globally for all users)

## Scopes

- `@RequestScope`: A new bean instance is created for each HTTP request.
- `@SessionScope`: A new bean instance is created per user session.
- `@ApplicationScope`: A single instance of the bean is created and shared across the entire application.

## Summary

| Scope               | Instance Per | Behavior                                           |
| ------------------- | ------------ | -------------------------------------------------- |
| `@RequestScope`     | HTTP Request | New instance for each request (resets every time). |
| `@SessionScope`     | User Session | Persists for the same user (stored in session).    |
| `@ApplicationScope` | Application  | Shared across all users, resets only on restart.   |

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
