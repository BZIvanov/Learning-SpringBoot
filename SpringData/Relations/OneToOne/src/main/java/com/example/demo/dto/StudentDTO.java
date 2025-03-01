package com.example.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
    private Long id;

    private String name;

    private String email;

    private StudentProfileDTO studentProfile;
}
