package com.example.demo.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    @GetMapping("/")
    public String publicEndpoint() {
        return "This is a public endpoint. No authentication required!";
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "Hello, User! You have access to this endpoint.";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Hello, Admin! You have access to this endpoint.";
    }
}
