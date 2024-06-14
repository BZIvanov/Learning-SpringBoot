package com.example.mycoolapp.rest;

import com.example.mycoolapp.common.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Teacher myTeacher;

    @Autowired
    public DemoController(@Qualifier("danceTeacher") Teacher teacher) {
        myTeacher = teacher;
    }

    @GetMapping("/subject")
    public String getSubject() {
        return myTeacher.getSubject();
    }
}
