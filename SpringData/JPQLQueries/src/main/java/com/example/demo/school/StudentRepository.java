package com.example.demo.school;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Calling the NamedQuery by its name
    List<Student> findByName(@Param("name") String name);

    List<Student> findStudentsOlderThan(@Param("age") int age);

    // Instead of named queries, we can have them defined directly here
    @Query("SELECT s FROM Student s WHERE s.email LIKE %:keyword%")
    List<Student> findByEmailContaining(@Param("keyword") String keyword);
}
