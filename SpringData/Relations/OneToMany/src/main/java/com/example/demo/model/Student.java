package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne(fetch = FetchType.LAZY)  // FetchType.LAZY is better for performance. In this demo, students will still be included in the API response because, we explicitly access school.getStudents() in SchoolService, triggering Hibernate to fetch them.
    @JoinColumn(name = "school_id")  // Foreign key in Student table
    private School school; // 👈 "school" is the field name referenced in mappedBy in School entity class
}
