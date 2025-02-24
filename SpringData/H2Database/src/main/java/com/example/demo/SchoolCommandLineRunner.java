package com.example.demo;

import com.example.demo.school.Course;
import com.example.demo.school.CourseDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SchoolCommandLineRunner implements CommandLineRunner {
    private final CourseDAO courseDAO;

    public SchoolCommandLineRunner(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        courseDAO.insert(new Course(0, "Java", "John")); // ID = 0 (auto-generated)
        courseDAO.insert(new Course(0, "JavaScript", "Jake"));
        courseDAO.insert(new Course(0, "HTML & CSS", "Anna"));

        courseDAO.deleteById(2);

        System.out.println("SELECTED COURSE: " + courseDAO.findById(1));
        System.out.println("SELECTED COURSE: " + courseDAO.findById(3));
    }
}
