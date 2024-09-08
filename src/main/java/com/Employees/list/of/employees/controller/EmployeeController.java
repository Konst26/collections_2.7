package com.Employees.list.of.employees.controller;

import com.Employees.list.of.employees.exception.ValidationException;
import com.Employees.list.of.employees.model.Employee;
import com.Employees.list.of.employees.service.EmployeeServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/employee")
public class EmployeeController {

    private final EmployeeServiceImpl service;

    public EmployeeController(EmployeeServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam int department,
                                @RequestParam int salary) {
        validate(firstName, lastName);
        return service.addEmployee(
                StringUtils.capitalize(firstName),
                StringUtils.capitalize(lastName),
                department,
                salary);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        validate(firstName, lastName);
        return service.removeEmployee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName));
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        validate(firstName, lastName);
        return service.findEmployees(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName));
    }

    @GetMapping("/all")
    public List<Employee> findEmployees() {
        List<Employee> employees = (List<Employee>) service.findEmployees();
        return employees;
    }

    private void validate(String... values) {
        for (String value : values) {
            if (!StringUtils.isAlpha(value)) {
            throw new ValidationException();
            }
        }
    }
}