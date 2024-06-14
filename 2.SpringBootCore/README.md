# Spring Boot core functionality

## IoC and DI

#### Inversion of Control (IoC)

Inversion of Control is a design principle used to invert the flow of control in a system. In traditional programming, the developer writes code that directly controls the flow of the application. With IoC, the control is inverted: the framework takes over the control flow, and the developer writes code that the framework calls at appropriate times. This allows for more modular and testable code.

In the context of Spring Boot, IoC is achieved through the use of the Spring IoC container. The container manages the lifecycle and configuration of application objects. Rather than the application code creating and managing dependencies, the container injects these dependencies where needed.

#### Dependency Injection

Dependency Injection is a specific implementation of IoC. It involves passing (injecting) the dependencies of a class to it, rather than the class creating the dependencies itself. DI helps to decouple the code and makes it easier to test and maintain.

In Spring Boot, DI is implemented through:

1. Constructor Injection: Dependencies are provided through the class constructor.

```java
@Service
public class MyService {
    private final MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }
}
```

2. Setter Injection: Dependencies are provided through setter methods.

```java
@Service
public class MyService {
    private MyRepository myRepository;

    @Autowired
    public void setMyRepository(MyRepository myRepository) {
        this.myRepository = myRepository;
    }
}
```

3. Field Injection: Dependencies are directly injected into fields.

```java
@Service
public class MyService {
    @Autowired
    private MyRepository myRepository;
}
```

The general recommendation is to use Constructor Injection. We should use Setter injection, when we have optional dependencies. Using Field injection is not recommended, mostly because of the unit testing.

## Spring Boot scanning

"scanning" refers to the process of automatically detecting and registering beans (components, configurations, services, repositories, etc.) in the application context. This is typically achieved through component scanning.

By default Spring is scanning packages and subpackages of the folder where our @SpringBootApplication is placed. If we want to scan packages outside that directory, we need to additionally configure it.
