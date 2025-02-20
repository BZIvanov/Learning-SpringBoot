package com.example.demo.school;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService {
    public List<Teacher> getTeachers() {
        List<Teacher> teachers = new ArrayList<>();

        Teacher teacher1 = new Teacher("John");
        Teacher teacher2 = new Teacher("Jake");
        Teacher teacher3 = new Teacher("Anna");
        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);

        return teachers;
    }
}
