package com.springsecurity.springsecurity.dynamicproxy;

import java.lang.reflect.Proxy;

public class Client {
	
	public static void main(String[] args) {
		ITEmployee itEmployee = new ITEmployee();
		itEmployee.setId(101);
		itEmployee.setName("venkatsh");
		itEmployee.setSalary(55555555.0);
		//itEmployee.giveHike(1100000000);
		EmployeeSalaryInvocationHandler emplHandler = new EmployeeSalaryInvocationHandler(itEmployee);
		IEmployee employee=(IEmployee)Proxy.newProxyInstance(ITEmployee.class.getClassLoader(), new Class[] {IEmployee.class}, emplHandler);
		employee.giveHike(5000);
		//System.out.println(employee);
		
	}

}
