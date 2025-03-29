package com.example.demo.users;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
    @GetMapping("public")
    public String publicEndpoint() {
        return "Public Endpoint - No authentication required!";
    }

    @GetMapping("secure")
    public String secureEndpoint() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "Secure Endpoint - Authenticated User: " + auth.getName();
    }
}
