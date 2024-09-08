package com.Employees.list.of.employees;

import com.Employees.list.of.employees.service.EmployeeServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final EmployeeServiceImpl employeeService;
    public DepartmentService (EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
}
