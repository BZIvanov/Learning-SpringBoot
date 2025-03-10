# App values demo

In this demo, we demonstrate, how to get get values defined in our `application.properties` file.

## Default value

In case we didn't provide in `application.properties` value for `teacher.name`, we will use "John" as a default value.

```java
@RestController
public class SchoolController {
    @Value("${teacher.name: John}")
    private String teacherName;

    @GetMapping("/")
    public String getTeacherInfo() {
        return teacherName;
    }
}
```

## Project config

The boilerplate code files were removed for simplicity. Only the essential files are in this demo.

- Project: Maven
- Language: Java 23
- Spring Boot: 3.4.3
- Dependencies:
  - Spring Web
