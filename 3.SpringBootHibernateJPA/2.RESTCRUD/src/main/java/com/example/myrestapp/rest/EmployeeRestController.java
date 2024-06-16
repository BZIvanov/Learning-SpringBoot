package com.example.myrestapp.rest;

import com.example.myrestapp.entity.Employee;
import com.example.myrestapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee not found: " + employeeId);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);

        return employeeService.upsertEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.upsertEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee not found: " + employeeId);
        }

        employeeService.deleteEmployee(employeeId);
    }
}
