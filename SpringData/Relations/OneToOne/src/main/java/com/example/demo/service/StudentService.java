package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.StudentProfileDTO;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDTO createStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return convertToDTO(savedStudent);
    }

    public Optional<StudentDTO> getStudentById(Long id) {
        return studentRepository.findById(id).map(this::convertToDTO);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    private StudentDTO convertToDTO(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .studentProfile(student.getStudentProfile() != null ?
                        new StudentProfileDTO(student.getStudentProfile().getId(),
                                student.getStudentProfile().getAddress(),
                                student.getStudentProfile().getPhoneNumber())
                        : null)
                .build();
    }
}
