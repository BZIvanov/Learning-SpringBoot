package com.example.demo.users;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    // Method can only be accessed by ADMIN
    @PreAuthorize("hasRole('ADMIN')") // Uses "ADMIN" without "ROLE_" prefix
    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Hello Admin! You have ADMIN access.";
    }

    // Only ADMIN can access
    @Secured("ROLE_ADMIN") // Must include "ROLE_" prefix
    @GetMapping("/secured-admin")
    public String securedAdminEndpoint() {
        return "Hello from Secured Admin Endpoint!";
    }

    // Only ADMIN can access, (From Java EE / JSR-250)
    @RolesAllowed("ADMIN")  // Uses "ADMIN" without "ROLE_" prefix
    @GetMapping("/roles-allowed-admin")
    public String rolesAllowedAdmin() {
        return "Hello from RolesAllowed Admin Endpoint!";
    }

    // Only USER can access
    @RolesAllowed("USER")
    @GetMapping("/user")
    public String userEndpoint() {
        return "Hello User! You have USER access.";
    }

    // @PostAuthorize Example (Allows the request but checks role **after execution**)
    @PostAuthorize("returnObject.contains('Admin')")
    @GetMapping("/postAuthorize")
    public String postAuthorizeTest(@RequestParam String name) {
        return "Hello " + name + "! Access granted.";
    }
}
