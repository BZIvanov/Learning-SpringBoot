# IoC and DI

Read [here](https://docs.spring.io/spring-framework/reference/core/beans.html) for the official IoC docs and [here](https://docs.spring.io/spring-framework/reference/core/beans/dependencies.html) for DI docs.

## Inversion of Control (IoC)

Inversion of Control is a design principle used to invert the flow of control in a system. In traditional programming, the developer writes code that directly controls the flow of the application. With IoC, the control is inverted: the framework takes over the control flow, and the developer writes code that the framework calls at appropriate times. This allows for more modular and testable code.

In the context of Spring, IoC is achieved through the use of the Spring IoC container (detailed info below in this file). The container manages the lifecycle and configuration of application objects. Rather than the application code creating and managing dependencies, the container injects these dependencies where needed.

## Dependency Injection

Dependency Injection is a specific implementation of IoC. It involves passing (injecting) the dependencies of a class to it, rather than the class creating the dependencies itself. DI helps to decouple the code and makes it easier to test and maintain.

In Spring, DI is implemented through:

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

## IoC Container

The Spring Container is the core of the Spring Framework that is responsible for managing the lifecycle, configuration, and dependencies of Spring beans. It is part of the Inversion of Control (IoC) principle, meaning that instead of manually creating and managing objects, the container does it for you.

### Why do we need the Spring Container?

- Removes Boilerplate Code – No need to manually instantiate and wire objects.
- Improves Testability – Makes unit testing easier with dependency injection.
- Promotes Loose Coupling – Objects don’t depend on each other directly.
- Manages Complex Configurations – Handles bean creation, initialization, and destruction automatically.

### Types of Spring Containers

Spring provides different container implementations:

| Container Type     | Description                                                                                                                                                    |
| ------------------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| BeanFactory        | A lightweight container that provides basic IoC functionality. Used in simple applications or resource-constrained environments.                               |
| ApplicationContext | A more advanced container that extends BeanFactory. Provides features like event propagation, AOP, and internationalization. Used in most Spring applications. |
