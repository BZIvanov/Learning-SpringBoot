package com.example.myrestapp.dao;

import com.example.myrestapp.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee upsertEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
