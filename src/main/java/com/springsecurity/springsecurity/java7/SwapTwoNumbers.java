package com.springsecurity.springsecurity.java7;

public class SwapTwoNumbers {
	public static void main(String[] args) {

		int a = 10;
		int b = 20;

		System.out.println("a is" + a + " b is " + b);

		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println(a + " and " + b);

	}

}
