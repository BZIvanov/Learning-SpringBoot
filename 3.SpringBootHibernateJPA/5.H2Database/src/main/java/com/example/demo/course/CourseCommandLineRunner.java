package com.example.demo.course;

import com.example.demo.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Java", "John"));
        repository.insert(new Course(2, "JavaScript", "Jake"));
        repository.insert(new Course(3, "HTML & CSS", "Anna"));

        repository.deleteById(2);

        System.out.println("SELECTED COURSE: " + repository.findById(1));
        System.out.println("SELECTED COURSE: " + repository.findById(3));
    }
}
