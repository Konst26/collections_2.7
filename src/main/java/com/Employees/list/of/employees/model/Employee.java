package com.Employees.list.of.employees.model;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int departmentId ;
    private final int salary;


    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = getDepartmentId();
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }
    public int getSalary() {
        return salary;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return departmentId == employee.departmentId && salary == employee.salary && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentId, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentId=" + departmentId +
                ", salary=" + salary +
                '}';
    }

    public void add(Employee employee) {

    }

    public boolean contains(Employee employee) {
        return false;
    }
}
