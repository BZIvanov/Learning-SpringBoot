package com.example.demo.school;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("")
    public String displayHomePage(Model model) {
        model.addAttribute("student", "John Doe");
        model.addAttribute("currentDate", new java.util.Date());

        // home is matching the template html file name
        return "home";
    }
}
