package com.example.demo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;

    private String name;

    private String email;

    private List<CourseDTO> courses;
}
