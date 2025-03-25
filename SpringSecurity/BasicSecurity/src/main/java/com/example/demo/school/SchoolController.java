package com.example.demo.school;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {
    @GetMapping("/")
    public String sayHello() {
        return "Cool school";
    }
}
