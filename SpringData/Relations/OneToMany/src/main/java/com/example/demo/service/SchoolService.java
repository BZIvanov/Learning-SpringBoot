package com.example.demo.service;

import com.example.demo.dto.SchoolDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.model.School;
import com.example.demo.model.Student;
import com.example.demo.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    // GET School by ID
    public SchoolDTO getSchoolById(Long id) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found"));
        return convertToDTO(school);
    }

    // CREATE School with Students
    public SchoolDTO createSchool(SchoolDTO schoolDTO) {
        School school = new School();
        school.setName(schoolDTO.getName());
        school.setLocation(schoolDTO.getLocation());

        List<Student> students = schoolDTO.getStudents().stream()
                .map(dto -> {
                    Student student = new Student();
                    student.setName(dto.getName());
                    student.setEmail(dto.getEmail());
                    student.setSchool(school);  // 👈 Establish relationship
                    return student;
                })
                .collect(Collectors.toList());

        school.setStudents(students);
        School savedSchool = schoolRepository.save(school);

        return convertToDTO(savedSchool);
    }

    // DELETE School (and its Students due to cascade)
    public void deleteSchool(Long id) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found"));
        schoolRepository.delete(school);
    }

    // Convert Entity to DTO (Prevents Infinite Recursion in JSON)
    private SchoolDTO convertToDTO(School school) {
        List<StudentDTO> studentDTOs = school.getStudents().stream()
                .map(student -> new StudentDTO(student.getId(), student.getName(), student.getEmail()))
                .collect(Collectors.toList());

        return new SchoolDTO(school.getId(), school.getName(), school.getLocation(), studentDTOs);
    }
}
