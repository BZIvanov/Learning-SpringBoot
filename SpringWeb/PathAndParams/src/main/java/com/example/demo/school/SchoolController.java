package com.example.demo.school;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {
    @GetMapping("/student/{id}")
    public String getStudentId(@PathVariable long id) {
        return "Student id is: " + id;
    }

    @GetMapping("/sum")
    public String addNumbers(@RequestParam int a, @RequestParam int b) {
        return "Sum: " + (a + b);
    }

    @GetMapping("/greet")
    public String getGreeting(@RequestParam(required = false, defaultValue = "Hello") String prefix) {
        return prefix + " user!";
    }

    @GetMapping("/subject")
    public String getSubject(@RequestParam(name = "choice", defaultValue = "Math") String desiredSubject) {
        return "Desired subject is " + desiredSubject;
    }
}
