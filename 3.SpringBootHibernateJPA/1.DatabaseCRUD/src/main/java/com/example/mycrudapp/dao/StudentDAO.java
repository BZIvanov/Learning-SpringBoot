package com.example.mycrudapp.dao;

import com.example.mycrudapp.entity.Student;

import java.util.List;

public interface StudentDAO {
    void create(Student student);

    Student findById(int id);

    List<Student> findAll();

    void update(Student student);

    void delete(int id);
}
