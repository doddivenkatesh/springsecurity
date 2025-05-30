package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class SecondHighestSalaray {
	public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 70000),
            new Employee("Bob", 85000),
            new Employee("Charlie", 92000),
            new Employee("Diana", 65000),
            new Employee("Eve", 85000) // Duplicate salary
        );

        OptionalDouble secondHighestSalary = employees.stream()
            .map(Employee::getSalary)
            .distinct()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst()
            .map(OptionalDouble::of)
            .orElse(OptionalDouble.empty());

        if (secondHighestSalary.isPresent()) {
            System.out.println("Second highest salary: " + secondHighestSalary.getAsDouble());
        } else {
            System.out.println("Not enough distinct salaries.");
        }}}
