# Spring Boot core functionality

## Spring Boot scanning

"scanning" refers to the process of automatically detecting and registering beans (components, configurations, services, repositories, etc.) in the application context. This is typically achieved through component scanning.

By default Spring is scanning packages and subpackages of the folder where our @SpringBootApplication is placed. If we want to scan packages outside that directory, we need to additionally configure it.

## @Lazy annotation

`@Lazy` annotation is used to indicate that a bean should be lazily initialized. This means that the bean will not be created and initialized until it is actually needed.

By default, Spring creates and initializes all singleton beans eagerly when the application context is started. You can change this behavior by marking a specific bean with the `@Lazy` annotation.

We can also apply the lazy globally.

## Bean lifecycle methods

Spring Boot manages the lifecycle of beans within its application context. Key lifecycle methods in Spring Boot provide hooks into the lifecycle stages of a bean, allowing for custom initialization and cleanup processes.

Below is example of one of the life cycle methods `@PostConstruct`:

```java
public class MyBean {
    @PostConstruct
    public void init() {
        // initialization code
    }
}
```

## Debugging technique

With the below example we can print the class name to the console from the constructor, when we are starting our application for example.

```java
public class MyClassComponent {
    public MyClassComponent() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
}
```
