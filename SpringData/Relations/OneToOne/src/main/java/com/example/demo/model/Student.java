package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private StudentProfile studentProfile;

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
        studentProfile.setStudent(this); // Maintain bidirectional consistency
    }
}
