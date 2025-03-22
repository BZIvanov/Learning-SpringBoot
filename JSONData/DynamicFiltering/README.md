# Dynamic filtering demo

`MappingJacksonValue` allows **dynamic filtering of JSON fields** when returning data from a REST API. It's useful when you **don't want to expose all fields** of an object in a response.

## Use Cases:

- Hiding sensitive data (e.g., passwords, internal IDs).
- Returning different data based on user roles or request parameters.

## Playing with the demo

For the following endpoint:

```bash
curl http://localhost:8080/user
```

the response will be:

```json
{
  "username": "john_doe",
  "email": "john@example.com"
}
```

---

For the following endpoint:

```bash
curl http://localhost:8080/user?view=admin
```

the response will be:

```json
{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "supersecret",
  "role": "ADMIN"
}
```
