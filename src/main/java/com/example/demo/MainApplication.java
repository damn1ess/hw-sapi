package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MainApplication implements CommandLineRunner {

	private final EmployeeService employeeService;

	public MainApplication(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
	public void run(String... args) {
		employeeService.addEmployee(new Employee("Artyom", "Polzikov", 1, 76_650));
		employeeService.addEmployee(new Employee("Gennady", "Chernenko", 3, 53_000));
		employeeService.addEmployee(new Employee("Sergey", "Krasnov", 2, 47_124));
		employeeService.addEmployee(new Employee("Alexandr", "Ostankov", 4, 86_030));
		employeeService.addEmployee(new Employee("Oxana", "Didenko", 5, 31_472));
		employeeService.addEmployee(new Employee("Vitally", "Zozulin", 2, 123_984));
		employeeService.addEmployee(new Employee("Ivan", "Tihonenko", 3, 87_178));
		employeeService.addEmployee(new Employee("Valery", "Atanov", 4, 79_764));
		employeeService.addEmployee(new Employee("illya", "Shatilov", 5, 75_651));
		employeeService.addEmployee(new Employee("Alexandra", "Volod'ko", 1, 28_453));
	}
}
