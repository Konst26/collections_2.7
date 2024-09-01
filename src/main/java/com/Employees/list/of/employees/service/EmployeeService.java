package com.Employees.list.of.employees.service;

import com.Employees.list.of.employees.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface EmployeeService {
    Employee add(String firstName, String lastName, int departmentId, int salary);
    Employee remove(String firstName, String lastName, int departmentId, int salary);
    Employee find(String firstName, String lastName, int departmentId, int salary);

    Collection<Employee> findAll();

}
