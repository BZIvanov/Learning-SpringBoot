package com.example.demo.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(studentDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.updateStudent(id, studentDTO));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<StudentDTO>> getStudentsByName(@PathVariable String name) {
        return ResponseEntity.ok(studentService.getStudentsByName(name));
    }

    @GetMapping("/older-than/{age}")
    public ResponseEntity<List<StudentDTO>> getStudentsOlderThan(@PathVariable int age) {
        return ResponseEntity.ok(studentService.getStudentsOlderThan(age));
    }

    @GetMapping("/email/{keyword}")
    public ResponseEntity<List<StudentDTO>> getStudentsByEmailKeyword(@PathVariable String keyword) {
        return ResponseEntity.ok(studentService.getStudentsByEmailKeyword(keyword));
    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<Void> deleteStudentByName(@PathVariable String name) {
        studentService.deleteStudentByName(name);
        return ResponseEntity.noContent().build();
    }
}
