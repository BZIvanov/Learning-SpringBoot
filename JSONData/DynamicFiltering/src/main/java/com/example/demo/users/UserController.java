package com.example.demo.users;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user")
    public MappingJacksonValue getUser(@RequestParam(required = false, defaultValue = "basic") String view) {
        // Sample user
        User user = new User("john_doe", "john@example.com", "supersecret", "ADMIN");

        // Define filtering logic
        SimpleBeanPropertyFilter filter;
        if ("admin".equalsIgnoreCase(view)) {
            filter = SimpleBeanPropertyFilter.serializeAllExcept(); // Show all fields for admin
        } else {
            filter = SimpleBeanPropertyFilter.filterOutAllExcept("username", "email"); // Hide password & role
        }

        // Apply filter to UserFilter. UserFilter value is defined in User class
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);

        // Wrap the user object with MappingJacksonValue
        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping;
    }
}
