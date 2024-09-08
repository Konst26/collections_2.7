package com.Employees.list.of.employees.service;

import com.Employees.list.of.employees.exception.EmployeeAlreadyAddedException;
import com.Employees.list.of.employees.exception.EmployeeNotFoundException;
import com.Employees.list.of.employees.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl {
    public static final int MAX_EMPLOYEES = 15;
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ivan", "Ivanov", 1, 10000),
            new Employee("Petr", "Ivanov", 2, 11000),
            new Employee("Ivan2", "Petrov", 3, 12000),
            new Employee("Vasya", "Petrov", 3, 15000)
    ));


    public Employee addEmployee(String firstName, String lastName, int departmentsId, int salary) {
        Employee employee = new Employee(firstName, lastName, departmentsId, salary);
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeNotFoundException();
        } else if (employee.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    public String removeEmployee(String firstName, String lastName) {
        boolean removed = employees.removeIf(p -> p.getFirstName().equals(firstName) && p.getLastName().equals(lastName));
        if (removed) {
            return "Сотрудник " + firstName + " " + lastName + " удален";
        }
        return "Сотрудник " + firstName + " " + lastName + " не найден!";
    }

    public Employee findEmployees(String firstName, String lastName) {
        return employees.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee findEmployees() {
        return null;
    }

    public Employee addEmployee(String firstName, String lastName) {
return null;
    }
}
