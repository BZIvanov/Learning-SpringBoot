package com.example.demo.service;

import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return convertToDTO(student);
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());

        List<Course> courses = studentDTO.getCourses().stream()
                .map(dto -> courseRepository.findById(dto.getId())
                        .orElseThrow(() -> new RuntimeException("Course not found")))
                .collect(Collectors.toList());

        student.setCourses(courses);
        Student savedStudent = studentRepository.save(student);
        return convertToDTO(savedStudent);
    }

    public StudentDTO enrollInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        student.getCourses().add(course);
        studentRepository.save(student);

        return convertToDTO(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


    // Convert Entity to DTO (Avoids Infinite Recursion)
    private StudentDTO convertToDTO(Student student) {
        List<CourseDTO> courseDTOs = student.getCourses().stream()
                .map(course -> new CourseDTO(course.getId(), course.getTitle(), course.getDescription()))
                .collect(Collectors.toList());

        return new StudentDTO(student.getId(), student.getName(), student.getEmail(), courseDTOs);
    }
}
