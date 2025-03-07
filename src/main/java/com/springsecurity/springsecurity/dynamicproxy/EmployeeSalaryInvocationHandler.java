package com.springsecurity.springsecurity.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class EmployeeSalaryInvocationHandler implements InvocationHandler{

	private IEmployee employeeTaraget;
	
	public EmployeeSalaryInvocationHandler (IEmployee employeeTaraget) {
		this.employeeTaraget=employeeTaraget;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		
		
		//pre processin 
		double hikeValue=(double)args[0];
		if(hikeValue <=0.0) {
			throw new RuntimeException("hike amount is not valid");
		}
		// making actual call  to my service layer
		Object returnValue=method.invoke(employeeTaraget, args);
		//post processin
		
		System.out.println("executing method :" + method.getName() + "for employee id : " + employeeTaraget);
		return returnValue;
	}

}
