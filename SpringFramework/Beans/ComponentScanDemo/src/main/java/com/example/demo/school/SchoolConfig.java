package com.example.demo.school;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// ensures all @Component classes in this package are automatically detected and registered as beans
// Without @ComponentScan, the Student class might not be found unless it is in the main application package
@ComponentScan(basePackages = "com.example.demo.school")
public class SchoolConfig {
}
