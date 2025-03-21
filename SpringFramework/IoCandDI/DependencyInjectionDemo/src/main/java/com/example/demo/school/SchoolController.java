package com.example.demo.school;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {
    private final Teacher teacher;

    // here we use Constructor injection for teacher
    // we are using Qualifier, because we have 2 teacher matching classes and Spring needs to know which one to inject
    public SchoolController(@Qualifier("mathTeacher") Teacher teacher) {
        this.teacher = teacher;
    }

    @GetMapping("/")
    public String getTeacherSubject() {
        return teacher.getSubject(); // will return "Math subject"
    }
}
