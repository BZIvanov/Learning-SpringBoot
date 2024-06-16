package com.example.myrestapp.dao;

import com.example.myrestapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    Employee upsertEmployee(Employee employee);

    void deleteEmployee(int id);
}
