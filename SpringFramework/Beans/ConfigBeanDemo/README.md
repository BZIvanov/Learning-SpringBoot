# Config Bean demo

Here we demonstrate, how to define Spring Beans using `@Bean` **(manual)** vs. `@Component` **(automatic)** and the difference between explicit bean registration and component scanning.

## Demo usage

Open `http://localhost:8080` to access the endpoint.

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.2
- Dependencies:
  - Spring Web

## Spring Boot scanning

"scanning" refers to the process of automatically detecting and registering beans (components, configurations, services, repositories, etc.) in the application context. This is typically achieved through component scanning.

By default Spring is scanning packages and subpackages of the folder where our @SpringBootApplication is placed. If we want to scan packages outside that directory, we need to additionally configure it.

## @Bean vs @Component

| Feature                        | `@Bean`                                        | `@Component`                                  |
| ------------------------------ | ---------------------------------------------- | --------------------------------------------- |
| **Where is it used?**          | Inside a `@Configuration` class                | Directly on a class                           |
| **Bean registration**          | Manual (explicitly defined)                    | Automatic (detected via scanning)             |
| **Customization**              | Allows full control (e.g., constructor params) | Less flexible (only default constructor used) |
| **For third-party classes?**   | ✅ Yes, works well                             | ❌ No, can't modify external classes          |
| **Requires `@ComponentScan`?** | ❌ No                                          | ✅ Yes (if not in the main package)           |

## Debugging technique

With the below example we can print the class name to the console from the constructor, when we are starting our application for example.

```java
public class MyClassComponent {
    public MyClassComponent() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
}
```
