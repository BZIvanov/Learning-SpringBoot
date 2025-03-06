package com.example.demo.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j  // @Slf4j (from Lombok) eliminates the need to declare a Logger manually.
@Service
public class UserService {
    public void createUser(String username) {
        log.info("Creating user: {}", username);
        log.debug("Debug info: Initializing user creation process");
        log.warn("Warning: Username might already exist");
        log.error("Error: Could not create user due to database issue");
    }
}
