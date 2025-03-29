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

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.4
- Dependencies:
  - Spring Web
  - Spring Security
