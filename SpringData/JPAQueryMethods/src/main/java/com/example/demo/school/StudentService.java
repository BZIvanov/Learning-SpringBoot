package com.example.demo.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public List<Student> getStudentsByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    public List<Student> getStudentsByAgeGreaterThan(int age) {
        return studentRepository.findByAgeGreaterThan(age);
    }

    public Student saveStudent(Student user) {
        return studentRepository.save(user);
    }
}
