package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {
    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/managers")
    public String showManagersPage() {
        return "managers";
    }

    @GetMapping("/admins")
    public String showAdminsPage() {
        return "admins";
    }
}
