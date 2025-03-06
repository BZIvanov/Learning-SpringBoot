package com.example.demo.school;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolProperties schoolProperties;

    @GetMapping("/info")
    public SchoolProperties getSchoolInfo() {
        return schoolProperties;
    }
}
