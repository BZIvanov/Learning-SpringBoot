# Lombok

Lombok is a Java library that reduces boilerplate code (e.g., getters, setters, constructors) using annotations like `@Data`, `@Getter`, `@Setter`, etc.

## Using Lombok with IntelliJ IDEA

1. Add Lombok dependency in your `pom.xml` (Maven) or `build.gradle` (Gradle)
2. Go to **Settings** → **Build, Execution, Deployment** → **Compiler** → **Annotation Processors** and check **Enable annotation processing**. After you start your app IntelliJ will most likely prompt you to enable annotation processing and if you agree you can skip this step.
3. Install Lombok Plugin: Go to **Settings** → **Plugins** → Search for "Lombok". Once you add Lombok in your pom.xml file for example IntelliJ will most likely prompt you to install the plugin, so you skip this step.

## @Slf4j Annotation

`@Slf4j` is a Lombok annotation that automatically generates a Logger instance for a class using **SLF4J (Simple Logging Facade for Java)**.

It eliminates manual logger creation like:

```java
private static final Logger log = LoggerFactory.getLogger(MyService.class);
```

### Simple usage

```java
@Slf4j
@Service
public class MyService {
    public void process() {
        log.info("Processing data...");
        log.debug("Debugging details...");
        log.error("An error occurred!");
    }
}
```
