package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departments")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalary(@RequestParam int departmentId) {
        return employeeService.getMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalary(@RequestParam int departmentId) {
        return employeeService.getMinSalaryByDepartment(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> getAllByDepartment(@RequestParam(required = false) Integer departmentId) {
        if (departmentId != null) {
            return employeeService.getAllEmployeesByDepartment(departmentId);
        }
        return employeeService.getAllEmployeesGroupedByDepartment().values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @GetMapping("/all/grouped")
    public Map<Integer, List<Employee>> getAllGrouped() {
        return employeeService.getAllEmployeesGroupedByDepartment();
    }
}