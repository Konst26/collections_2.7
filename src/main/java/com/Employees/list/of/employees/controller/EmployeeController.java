package com.Employees.list.of.employees.controller;

import com.Employees.list.of.employees.model.Employee;
import com.Employees.list.of.employees.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping ("/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService employeeService) {
        this.service = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam int departmentId,
                                @RequestParam int salary) {
        return service.add(firstName, lastName, departmentId, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, String lastName, int departmentId, int salary) {
        return service.remove(firstName, lastName, departmentId, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, String lastName, int departmentId, int salary) {
        return service.find(firstName, lastName, departmentId, salary);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }



}
