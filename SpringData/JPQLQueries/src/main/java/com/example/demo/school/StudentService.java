package com.example.demo.school;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = new Student(null, studentDTO.getName(), studentDTO.getEmail(), studentDTO.getAge());
        Student savedStudent = studentRepository.save(student);
        return convertToDTO(savedStudent);
    }

    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setAge(studentDTO.getAge());
        Student updatedStudent = studentRepository.save(student);
        return convertToDTO(updatedStudent);
    }

    public List<StudentDTO> getStudentsByName(String name) {
        return studentRepository.findByName(name).stream().map(this::convertToDTO).toList();
    }

    public List<StudentDTO> getStudentsOlderThan(int age) {
        return studentRepository.findStudentsOlderThan(age).stream().map(this::convertToDTO).toList();
    }

    public List<StudentDTO> getStudentsByEmailKeyword(String keyword) {
        return studentRepository.fetchByEmailContaining(keyword).stream().map(this::convertToDTO).toList();
    }

    @Transactional
    public void deleteStudentByName(String name) {
        studentRepository.removeUserByName(name);
    }

    // Helper method to convert Entity to DTO
    private StudentDTO convertToDTO(Student student) {
        return new StudentDTO(student.getId(), student.getName(), student.getEmail(), student.getAge());
    }
}
