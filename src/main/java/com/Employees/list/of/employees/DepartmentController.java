package com.Employees.list.of.employees;

import com.Employees.list.of.employees.model.Employee;
import com.Employees.list.of.employees.sevice.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public  DepartmentController(DepartmentService service) {
    this.service = service;
    }

    @GetMapping("/max_salary")
    public Employee max(@RequestParam int departmentId) {
        return service.getMaxSalary(departmentId);
    }

    @GetMapping("/min_salary")
    public Employee min(@RequestParam int departmentId) {
        return service.getMinSalary(departmentId);
    }

    @GetMapping(value = "/all-by-dept")
    public List<Employee> all(@RequestParam int departmentId) {
        return service.getByDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> all () {
        return service.groupByDepartment();
    }
}
