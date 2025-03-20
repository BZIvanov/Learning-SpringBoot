# Logs demo

## Playing with this demo

1. Open a browser or Postman and test these endpoints:
   - `http://localhost:8080/test/info` → Logs an INFO message.
   - `http://localhost:8080/test/debug` → Logs a DEBUG message.
   - `http://localhost:8080/test/warn` → Logs a WARN message.
   - `http://localhost:8080/test/error` → Logs an ERROR message.
   - `http://localhost:8080/test/simulate-exception` → Logs an Exception.
2. Check the **console output** or `logs/app.log` file.

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 24
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
