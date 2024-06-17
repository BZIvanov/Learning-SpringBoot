package com.example.myrestapp.dao;

import com.example.myrestapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// here is how to provide custom name to be used in the endpoint
// by default, it will be pluralized to employees anyway, but this is just for example
@RepositoryRestResource(path = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // no need of all the boilerplate code here, JPA will provide it ready to use
}
