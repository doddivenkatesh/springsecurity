package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FirstHighestSalary {
	public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 70000),
            new Employee("Bob", 85000),
            new Employee("Charlie", 92000),
            new Employee("Diana", 65000)
        );

        Optional<Employee> highestPaid = employees.stream()
            .max(Comparator.comparingDouble(Employee::getSalary));

        highestPaid.ifPresent(emp ->
            System.out.println("Highest paid employee: " + emp)
        );
        
        double highestSalary = employees.stream()
        	    .mapToDouble(Employee::getSalary)
        	    .max()
        	    .orElse(0.0);
    }
}
