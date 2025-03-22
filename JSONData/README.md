# JSON Data

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

## Content

Recommended learning order for this section:

1. DynamicFiltering
