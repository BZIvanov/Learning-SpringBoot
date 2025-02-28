package com.example.demo.school;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Find student by first name
    List<Student> findByFirstName(String firstName);

    // Find student by last name, ignoring case
    List<Student> findByLastNameIgnoreCase(String lastName);

    // Find students by age greater than a given value
    List<Student> findByAgeGreaterThan(int age);

    // Find students by age between two values
    List<Student> findByAgeBetween(int startAge, int endAge);

    // Find student by email
    Optional<Student> findByEmail(String email);

    // Find students by first name and last name
    List<Student> findByFirstNameAndLastName(String firstName, String lastName);
}
