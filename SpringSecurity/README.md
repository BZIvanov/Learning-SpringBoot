# Spring Security

## `Authentication` Object

The `Authentication` object in Spring Security represents the principal (user, system, or service) that has been authenticated (or is in the process of being authenticated). It contains security-related information such as the identity, credentials, and granted authorities (roles/permissions).

### Where is it used?

The `Authentication` object is part of the **SecurityContext**, which holds the security information of the current request.

### Key components of `Authentication`

`Authentication` is an interface in Spring Security (`org.springframework.security.core.Authentication`) and has the following important methods:

- `getPrincipal()` → Returns the user details (typically a `UserDetails` object).
- `getCredentials()` → Returns the password or authentication token.
- `getAuthorities()` → Returns the roles/permissions assigned to the user.
- `isAuthenticated()` → Checks if the user is authenticated.
- `getDetails()` → Additional details about the authentication request (e.g., IP address).
- `getName()` → Returns the username of the authenticated principal.

### How is it used?

Retrieving the Authentication Object:

```java
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
String username = authentication.getName();
Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();
```

## Filters and Filter Chain

### Filter

A **Filter** in Spring Security is a component that intercepts HTTP requests and applies security logic (e.g., authentication, authorization, logging, etc.). It is part of the **Servlet Filter API** (`javax.servlet.Filter`) and is executed before the request reaches the controller.

**Examples of Security Filters**:

- `UsernamePasswordAuthenticationFilter` → Handles authentication using username & password.
- `BasicAuthenticationFilter` → Processes HTTP Basic Authentication.
- `BearerTokenAuthenticationFilter` → Extracts JWT tokens from requests.
- `CsrfFilter` → Protects against CSRF attacks.
- `SecurityContextPersistenceFilter` → Maintains security context across requests.

### Filter Chain

The **Filter Chain** is a sequence of filters that Spring Security applies to incoming requests. Each request goes through multiple filters before reaching the application logic.

Spring Security manages these filters using a `FilterChainProxy`, which delegates requests to the correct security filter chain based on configuration.

If we don't provide our custom FilterChain, the default one will be used, which require authentication for all the endpoints.

**Example Flow in Filter Chain:**

1. `SecurityContextPersistenceFilter` → Loads security context.
2. `UsernamePasswordAuthenticationFilter` → Authenticates user credentials.
3. `BasicAuthenticationFilter` → Handles Basic Authentication (if enabled).
4. `BearerTokenAuthenticationFilter` → Extracts and validates JWT tokens.
5. `AuthorizationFilter` → Checks user roles & permissions.
6. `FilterSecurityInterceptor` → Enforces access control decisions.

## Content

Recommended learning order for this section:

1. BasicSecurity
2. InMemoryUsers
3. SecuredEndpoints
4. RolesBasedAccess
5. CustomFilter
