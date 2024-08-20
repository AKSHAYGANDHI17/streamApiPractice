package com.example.implementation;

import com.example.beans.Employee;
import com.example.interfaces.Example2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDetails implements Example2 {
    @Override
    public List<Employee> empDeatils() {


        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, 60000, "HR"),
                new Employee("Bob", 25, 48000, "Engineering"),
                new Employee("Charlie", 35, 52000, "Engineering"),
                new Employee("David", 28, 49000, "HR"),
                new Employee("Eve", 40, 55000, "Finance")
        );

        List<Employee> results = employees.stream().filter(e -> e.getSalary() > 50000).sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).collect(Collectors.toList());

        return results;
    }
}
