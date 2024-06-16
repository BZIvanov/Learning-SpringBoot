package com.example.myrestapp.service;

import com.example.myrestapp.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    Employee upsertEmployee(Employee employee);

    void deleteEmployee(int id);
}
