package com.example.demo.school;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@NamedQueries({
        @NamedQuery(
                name = "Student.findByName",
                query = "SELECT s FROM Student s WHERE s.name = :name"
        ),
        @NamedQuery(
                name = "Student.findStudentsOlderThan",
                query = "SELECT s FROM Student s WHERE s.age > :age"
        )
})
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

    private int age;
}
