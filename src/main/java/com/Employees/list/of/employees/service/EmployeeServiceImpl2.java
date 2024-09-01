package com.Employees.list.of.employees.service;

import com.Employees.list.of.employees.exception.EmployeeAlreadyAddedException;
import com.Employees.list.of.employees.exception.EmployeeNotFoundException;
import com.Employees.list.of.employees.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl2 implements EmployeeService {
    private static final int MAX_EMPLOYEES = 15;
    private final List<Employee> employees = new ArrayList<>(List.of(
      new Employee("Ivan", "Ivanov", 1, 10000)
      new Employee("Petr", "Ivanov", 2, 1000);
            new Employee("Petr","Petrov",2, 15000);
            new Employee("John","Smith",2,12000);
            new Employee("Ivan", "Ivanov", 3, 20000);
            new Employee("Petr", "Ivanov", 3, 30000)));

    public List<Employee> getEmployees() {
        return employees;
    }


    @Override
    public Employee add(String firstName, String lastName, int departmentId, int salary) {
        return null;
    }

    @Override
    public Employee remove(String firstName, String lastName, int departmentId, int salary) {
        return null;
    }

    @Override
    public Employee find(String firstName, String lastName, int departmentId, int salary) {
        return null;
    }

    @Override
    public Collection<Employee> findAll() {
        return List.of();
    }
}

    @Override
    public Employee add(String firstName, String lastName, int departmentId, int salary) {
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeAlreadyAddedException();
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public String remove(String firstName, String lastName) {
        boolean removed = employees.removeIf(p -> p.getFirstName().equals(firstName) && p.getLastName().equals(lastName));
        if (removed) {
            return "Сотрудник " + firstName + " " + lastName + " удален.";
        }
        return "Сотрудник " + firstName + " " + lastName + " не найден";
    }

    @Override
    public Employee find(String firstName, String lastName) {
        return employees.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
        }

    @Override
    public Collection<Employee> findAll() {
        List<Employee> employees = List.of();
        return employees;
    }
