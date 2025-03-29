# Roles based access demo

In this demo, we showcase **method-level security** using annotations like `@PreAuthorize`, `@Secured`, `@RolesAllowed`, and `@PostAuthorize` to restrict access based on user roles. Unlike traditional **URL-based security** configured in `SecurityFilterChain`, this approach secures individual methods, providing fine-grained access control.

## Test endpoints

If testing with Postman, you should use `Basic Auth` and provide **username and password**, which you can find in the security configuration class in this demo.

Use `GET` method for all endpoints.

- **Login as admin** (`admin/admin123`)
  - `/admin` → ✅ Allowed
  - `/secured-admin` → ✅ Allowed
  - `/roles-allowed-admin` → ✅ Allowed
  - `/user` → ❌ Forbidden
  - `/postAuthorize?name=Admin` → ✅ Allowed
  - `/postAuthorize?name=User` → ❌ Forbidden
- **Login as user** (`user/user123`)
  - `/admin` → ❌ Forbidden
  - `/secured-admin` → ❌ Forbidden
  - `/roles-allowed-admin` → ❌ Forbidden
  - `/user` → ✅ Allowed
  - `/postAuthorize?name=Admin` → ✅ Allowed
  - `/postAuthorize?name=User` → ❌ Forbidden
- **No authentication (Not logged in)**
  - ❌ All endpoints return `401 Unauthorized`

## Understanding `@PostAuthorize("returnObject.contains('Admin')")`

1. `@PostAuthorize` executes after the method runs.
2. It evaluates the return value (`returnObject`).
3. If the condition in `@PostAuthorize` evaluates to `false`, Spring Security **denies access (403 Forbidden)**.

## `PasswordEncoder` annotation

The `PasswordEncoder` interface in Spring Security is used to **hash and verify passwords securely** instead of storing plaintext passwords. It helps prevent security vulnerabilities like **password leaks and rainbow table attacks**.

### Key features

- `One-Way Hashing` – Passwords are stored as hashes, not plaintext.
- `Salting & Encoding` – Prevents brute-force attacks.
- `Multiple Implementations` – Supports different hashing algorithms.

### Common `PasswordEncoder` implementations

| **Implementation**          | **Description**                                   | **Use Case**                                    |
| --------------------------- | ------------------------------------------------- | ----------------------------------------------- |
| `NoOpPasswordEncoder`       | (Insecure!) Stores plaintext passwords.           | Only for testing (not recommended).             |
| `BCryptPasswordEncoder`     | Uses BCrypt hashing (secure & recommended).       | Default choice for most applications.           |
| `Argon2PasswordEncoder`     | Uses Argon2 hashing (memory-hard algorithm).      | For extra security (more resistant to attacks). |
| `Pbkdf2PasswordEncoder`     | Uses PBKDF2 (key stretching algorithm).           | Secure alternative to BCrypt.                   |
| `SCryptPasswordEncoder`     | Uses SCrypt (memory-intensive hashing).           | Similar to Argon2, good for high-security apps. |
| `DelegatingPasswordEncoder` | Supports multiple encoders and allows migrations. | Used for backward compatibility.                |

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.4
- Dependencies:
  - Spring Web
  - Spring Security
