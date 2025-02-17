package com.example.demo.school;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchoolConfig {
    @Bean
    Student student1() {
        var student = new Student();
        student.setName("John");
        return student;
    }

    @Bean
    Student student2() {
        var student = new Student();
        student.setName("Jake");
        return student;
    }

    // we can specify custom names for our beans in case we don't want the default generated name
    @Bean(name = "ani")
    Student student3() {
        var student = new Student();
        student.setName("Anna");
        return student;
    }
}
