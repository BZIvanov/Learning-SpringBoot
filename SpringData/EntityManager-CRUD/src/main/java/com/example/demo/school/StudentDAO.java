package com.example.demo.school;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO {
    // PersistenceContext annotation is used to inject the EntityManager instance
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Student save(Student student) {
        entityManager.persist(student); // Insert
        return student;
    }

    public Student findById(Long id) {
        return entityManager.find(Student.class, id); // Retrieve
    }

    public List<Student> findAll() {
        return entityManager.createQuery("SELECT s FROM Student s ORDER BY s.lastName", Student.class).getResultList();
    }

    @Transactional
    public Student update(Student student) {
        return entityManager.merge(student); // Update
    }

    @Transactional
    public void deleteById(Long id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student); // Delete
        }
    }
}
