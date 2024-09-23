package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();

    public void addEmployee(Employee employee) {
        String key = employee.getFirstName() + " " + employee.getLastName();
        if (!employees.containsKey(key)) {
            employees.put(key, employee);
        }
    }

    public Employee getMaxSalaryByDepartment(int departmentId) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    public Employee getMinSalaryByDepartment(int departmentId) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> getAllEmployeesByDepartment(int departmentId) {
        return employees.values().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return employees.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
