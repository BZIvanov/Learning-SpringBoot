package com.example.demo.school;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    // return the home.html for all 3 endpoints below
    @RequestMapping(value = {"", "/", "/home"})
    public String displayHomePage() {
        // Spring has ready to use configuration to pick up and return the html file
        return "home.html";
    }
}
