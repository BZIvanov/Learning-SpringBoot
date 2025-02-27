package com.example.demo.controller;

import com.example.demo.exception.InvalidInputException;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/find")
    public String findResource(@RequestParam String name) {
        if (name.equalsIgnoreCase("error")) {
            throw new ResourceNotFoundException("Resource not found with name: " + name);
        }
        return "Resource found: " + name;
    }

    @GetMapping("/validate")
    public String validateInput(@RequestParam int age) {
        if (age < 0) {
            throw new InvalidInputException("Age cannot be negative.");
        }
        return "Valid age: " + age;
    }
}
