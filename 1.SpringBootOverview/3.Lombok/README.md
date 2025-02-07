# Lombok Demo

Some of the boilerplate files for this project were removed for simplicity, only essentials are left.

## Lombok

Lombok is a Java library that reduces boilerplate code (e.g., getters, setters, constructors) using annotations like `@Data`, `@Getter`, `@Setter`, etc.

### Using Lombok with IntelliJ IDEA

1. Add Lombok dependency in your `pom.xml` (Maven) or `build.gradle` (Gradle)
2. Go to **Settings** → **Build, Execution, Deployment** → **Compiler** → **Annotation Processors** and check **Enable annotation processing**. After you start your app IntelliJ will most likely prompt you to enable annotation processing and if you agree you can skip this step.
3. Install Lombok Plugin: Go to **Settings** → **Plugins** → Search for "Lombok". Once you add Lombok in your pom.xml file for example IntelliJ will most likely prompt you to install the plugin, so you skip this step.

## Jackson

**Jackson** is a popular Java library used in Spring Boot for parsing and processing JSON data. It is included by default with Spring Boot's `spring-boot-starter-web` dependency.

### Key Features

- **Serialization & Deserialization**: Converts Java objects to JSON and vice versa.
- **Annotations**: Supports `@JsonProperty`, `@JsonIgnore`, `@JsonInclude`, etc., for customization.
- **Custom Object Mapping**: Allows custom serializers/deserializers using `ObjectMapper`.
- **Integration with Spring Boot**: Automatically configured, but can be customized using `Jackson2ObjectMapperBuilder`.

### Example

Here, Jackson automatically converts JSON in the request body to a User object.

```java
@RestController
public class UserController {
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(user);
    }
}
```
