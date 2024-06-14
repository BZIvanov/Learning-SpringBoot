package com.example.mycoolapp.rest;

import com.example.mycoolapp.common.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Teacher myTeacher;

    // here we use Constructor injection
    @Autowired
    public DemoController(Teacher teacher) {
        myTeacher = teacher;
    }

    @GetMapping("/subject")
    public String getSubject() {
        return myTeacher.getSubject();
    }
}
