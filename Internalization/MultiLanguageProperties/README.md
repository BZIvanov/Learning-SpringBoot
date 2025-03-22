# Multiple languages properties demo

- `MessageSource` loads translations from **messages_xx.properties**.
- `LocaleResolver` detects the user’s language.
- **Dynamic language selection** via `Accept-Language` header or request parameters.

## Playing with the demo

Using Browser or Postman test different languages by sending a GET requests.

- `curl -H "Accept-Language: en" http://localhost:8080/greet`
- `curl -H "Accept-Language: fr" http://localhost:8080/greet`
- `curl http://localhost:8080/farewell?lang=es`

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 24
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
