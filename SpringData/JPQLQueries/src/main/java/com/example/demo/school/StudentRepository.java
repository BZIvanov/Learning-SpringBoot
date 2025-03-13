package com.example.demo.school;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Calling the NamedQuery by its name
    List<Student> findByName(@Param("name") String name);

    List<Student> findStudentsOlderThan(@Param("age") int age);

    // Instead of named queries, we can have them defined directly here
    @Query("SELECT s FROM Student s WHERE s.email LIKE %:keyword%")
    List<Student> fetchByEmailContaining(@Param("keyword") String keyword);


    // For Create/Update/Delete operations, we need to use @Modifying and @Transactional
    @Modifying
    @Transactional
    @Query("DELETE FROM Student s WHERE s.name = :name")
    void removeUserByName(@Param("name") String name);
}
