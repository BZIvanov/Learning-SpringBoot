package com.example.demo.school;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {
    private final Teacher teacher;

    public SchoolController(@Qualifier("mathTeacher") Teacher teacher) {
        this.teacher = teacher;
    }

    @GetMapping("/")
    public String getTeacherSubject() {
        return teacher.getSubject();
    }
}
