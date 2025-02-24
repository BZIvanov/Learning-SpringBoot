package com.example.demo.school;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Transactional
    public Student save(Student student) {
        return studentDAO.save(student);
    }

    public Student findById(Long id) {
        return studentDAO.findById(id);
    }

    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Transactional
    public Student update(Long id, Student student) {
        student.setId(id); // Ensure correct ID before updating
        return studentDAO.update(student);
    }

    @Transactional
    public void deleteById(Long id) {
        studentDAO.deleteById(id);
    }
}
