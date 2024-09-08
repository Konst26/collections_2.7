package com.Employees.list.of.employees.service;

import com.Employees.list.of.employees.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find (String firstName, String lastName);

    Collection<Employee> findAll();
}
