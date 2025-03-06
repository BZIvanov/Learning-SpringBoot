package com.example.demo.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create-user")
    public String createUser(@RequestParam(required = false, defaultValue = "Guest") String username) {
        log.info("Received request to create user: {}", username);
        userService.createUser(username);
        return "User created!";
    }
}
