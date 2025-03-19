package com.example.demo.company;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return repository.findById(id);
    }

    public int addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public int updateEmployee(Employee employee) {
        return repository.update(employee);
    }

    public int deleteEmployee(int id) {
        return repository.delete(id);
    }
}
