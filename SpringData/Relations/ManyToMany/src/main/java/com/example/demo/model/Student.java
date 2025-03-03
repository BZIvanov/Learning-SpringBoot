package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @ManyToMany
    @JoinTable(
            name = "student_courses", // 👈 Join table name
            joinColumns = @JoinColumn(name = "student_id"),  // 👈 Foreign key to Student
            inverseJoinColumns = @JoinColumn(name = "course_id")  // 👈 Foreign key to Course
    )
    private List<Course> courses = new ArrayList<>();
}
