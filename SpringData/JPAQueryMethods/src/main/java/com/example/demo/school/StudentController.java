package com.example.demo.school;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Add new student
    @PostMapping
    public Student createUser(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Find by first name
    @GetMapping("/firstName/{firstName}")
    public List<Student> getStudentsByFirstName(@PathVariable String firstName) {
        return studentService.getStudentsByFirstName(firstName);
    }

    // Find by email
    @GetMapping("/email/{email}")
    public Optional<Student> getStudentByEmail(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }

    // Find students older than a certain age
    @GetMapping("/olderThan/{age}")
    public List<Student> getStudentsOlderThan(@PathVariable int age) {
        return studentService.getStudentsByAgeGreaterThan(age);
    }
}
