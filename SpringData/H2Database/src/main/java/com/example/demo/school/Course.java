package com.example.demo.school;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course {
    // all columns names are matching the database table names and we are not going to use additional configuration for this demo
    // so we will completely skip @Column annotation for all fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String author;
}
