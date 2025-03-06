# App properties demo

## Playing with the demo

**GET** `http://localhost:8080/school/info` and you will see the following response:

```json
{
  "rating": 5,
  "contact": {
    "phone": "123456789",
    "email": "school@mail.com"
  },
  "teachers": ["John Doe", "Alice Doe", "Jake Doe"]
}
```

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
  - Lombok
  - Validation
