package com.example.demo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {
    @GetMapping("/user")
    public String getUser() {
        throw new RuntimeException("Something went wrong in Web!");
    }
}
