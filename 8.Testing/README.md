# Testing

## Spring framework testing vs. Spring Boot testing

Click [here](https://docs.spring.io/spring-framework/reference/testing.html) for Spring framework testing docs and [here](https://docs.spring.io/spring-boot/reference/testing/index.html) for Spring Boot testing docs.

### Spring framework testing

**Focus**: General testing support in the Spring Framework (i.e., core dependency injection, transactions, and context loading).

**When to use**:

- If you are working on a non-Spring Boot project (e.g., traditional Spring Framework apps).
- You need lower-level testing features (e.g., `@ContextConfiguration`, `TestContext Framework`).
- You're testing components that don’t rely on Spring Boot auto-configuration.

**Includes**:

- Core Spring testing features (`@ContextConfiguration`, `TestExecutionListener`)
- Transactional tests (`@Transactional`)
- Mocking beans in the application context

### Spring Boot testing

**Focus**: Testing in a Spring Boot application (i.e., auto-configuration, embedded servers, simplified setup).

**When to use**:

- If you are working on a Spring Boot project.
- You need Spring Boot-specific test annotations (`@SpringBootTest`, `@DataJpaTest`, `@WebMvcTest`).
- You want to test Spring Boot auto-configuration or components like repositories, services, controllers, etc.

**Includes**:

- Auto-configured test slices (`@DataJpaTest`, `@WebMvcTest`, etc.)
- Testing with JUnit, Testcontainers, and MockMvc
- Integration testing with Spring Boot

### Which One Should You Use?

✅ For core Spring projects (non-Boot): Use Spring Framework Testing Docs (more flexibility, framework-agnostic).
✅ For Spring Boot projects: Use Spring Boot Testing Docs (easier setup, Boot-specific features).

If you’re using **Spring Boot**, you generally don’t need to look at the Spring Framework Testing guide unless you’re dealing with low-level Spring configurations.

## @DataJpaTest

Link to the official [docs](https://docs.spring.io/spring-boot/api/java/org/springframework/boot/test/autoconfigure/orm/jpa/DataJpaTest.html).

`@DataJpaTest` is a Spring Boot annotation used for testing JPA repositories. It configures an in-memory database, scans for JPA repositories, and disables full auto-configuration to keep tests lightweight.

### Key features

- Loads only JPA-related components.
- Uses an embedded database by default (like H2, HSQL, or Derby).
- Rolls back transactions after each test to maintain isolation.
- Provides `TestEntityManager` for database interactions.

### Example

```java
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        User user = new User("John", "john@example.com");
        User savedUser = userRepository.save(user);
        assertNotNull(savedUser.getId());
    }
}
```
