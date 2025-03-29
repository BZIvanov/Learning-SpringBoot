# Custom Filter demo

- We created a custom filter that checks for a custom authentication header (`X-Custom-Auth`).
- If the header contains "valid-token", the filter authenticates the user.
- We registered the filter using `addFilterBefore()`, ensuring it runs before Spring's authentication filters.
- Tested different scenarios to verify access control.

## Testing the Custom Filter

1. **Access public endpoint (no authentication required)**

```http
GET http://localhost:8080/public
```

Response: `Public Endpoint - No authentication required!`

---

2. **Access secure endpoint without authentication**

```http
GET http://localhost:8080/secure
```

Response: `Response: 403 Forbidden (because authentication is required)`

---

3. **Access secure endpoint with custom header**

```http
GET http://localhost:8080/secure
X-Custom-Auth: valid-token
```

Response: `Secure Endpoint - Authenticated User: customUser`

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.4
- Dependencies:
  - Spring Web
  - Spring Security
