package com.example.demo.school;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService {
    public List<Teacher> getTeachers(boolean shouldThrow) {
        if (shouldThrow) {
            throw new RuntimeException("MY INTENTIONAL ERROR");
        }

        List<Teacher> teachers = new ArrayList<>();
        Teacher teacher = new Teacher("John");
        teachers.add(teacher);

        return teachers;
    }
}
