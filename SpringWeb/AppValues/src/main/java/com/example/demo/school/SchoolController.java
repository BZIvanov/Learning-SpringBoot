package com.example.demo.school;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {
    // these values are defined in our application.properties file
    @Value("${teacher.name}")
    private String teacherName;

    @Value("${teacher.subject}")
    private String teacherSubject;

    @GetMapping("/")
    public String getTeacherInfo() {
        return teacherName + " teaches " + teacherSubject;
    }
}
