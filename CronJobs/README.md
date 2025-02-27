# Cron jobs

Read the [docs](https://docs.spring.io/spring-boot/reference/features/task-execution-and-scheduling.html).

In Spring Boot, you can schedule tasks using the @Scheduled annotation.

## Simple cron job example

```java
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Scheduled(cron = "0 0/5 * * * ?") // Runs every 5 minutes
    public void executeTask() {
        System.out.println("Scheduled task running at: " + java.time.LocalDateTime.now());
    }
}
```

## Steps to enable scheduling

1. Add `@EnableScheduling` in your main application class:

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Enables scheduled tasks
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```

2. Restart your application, and you'll see the task executing in the console every 5 minutes.

## Fixed rate execution

```java
@Scheduled(fixedRate = 5000) // Runs every 5 seconds
public void fixedRateTask() {
    System.out.println("Fixed rate task running...");
}
```
