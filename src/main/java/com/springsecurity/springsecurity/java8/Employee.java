package com.springsecurity.springsecurity.java8;

public class Employee {
	 private String name;
	    private double salary;

	    // Constructor
	    public Employee(String name, double salary) {
	        this.name = name;
	        this.salary = salary;
	    }

	    // Getters
	    public String getName() {
	        return name;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    // For pretty printing
	    @Override
	    public String toString() {
	        return "Employee{name='" + name + "', salary=" + salary + "}";
	    }
}
