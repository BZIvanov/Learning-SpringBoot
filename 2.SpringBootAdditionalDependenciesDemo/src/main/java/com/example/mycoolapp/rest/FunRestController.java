package com.example.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// example of simple endpoint
@RestController
public class FunRestController {
    // these values are defined in our application.properties file
    @Value("${employee.name}")
    private String employeeName;

    @Value("${employee.city}")
    private String employeeCity;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/employee")
    public String getEmployeeInfo() {
        return employeeName + " lives in " + employeeCity;
    }
}
