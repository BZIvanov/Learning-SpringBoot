package com.example.demo.school;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // no need of all the boilerplate code here, JPA will provide it ready to use
}
