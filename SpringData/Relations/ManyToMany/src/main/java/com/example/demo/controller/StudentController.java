package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(studentDTO));
    }

    @PostMapping("/{studentId}/enroll/{courseId}")
    public ResponseEntity<StudentDTO> enrollStudent(@PathVariable Long studentId, @PathVariable Long courseId) {
        return ResponseEntity.ok(studentService.enrollInCourse(studentId, courseId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
