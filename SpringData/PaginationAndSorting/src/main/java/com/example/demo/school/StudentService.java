package com.example.demo.school;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id).map(existingStudent -> {
            if (updatedStudent.getName() != null) {
                existingStudent.setName(updatedStudent.getName());
            }
            if (updatedStudent.getSemester() != null) {
                existingStudent.setSemester(updatedStudent.getSemester());
            }
            if (updatedStudent.getLearningBudget() != null) {
                existingStudent.setLearningBudget(updatedStudent.getLearningBudget());
            }
            if (updatedStudent.getExamDate() != null) {
                existingStudent.setExamDate(updatedStudent.getExamDate());
            }
            return studentRepository.save(existingStudent);
        }).orElseThrow(() -> new EntityNotFoundException("Student not found with ID: " + id));
    }

    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
