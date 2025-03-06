package com.example.demo.school;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Validated
@ConfigurationProperties(prefix = "school")
public class SchoolProperties {
    @Min(1)  // Minimum rating allowed is 1
    @Max(5)  // Maximum rating allowed is 5
    private int rating;

    @NotNull
    private Contact contact;

    @NotEmpty  // Ensures at least one teacher is present
    private List<String> teachers;

    @Data
    public static class Contact {
        @NotEmpty
        private String phone;

        @Email  // Validates email format
        private String email;
    }
}
