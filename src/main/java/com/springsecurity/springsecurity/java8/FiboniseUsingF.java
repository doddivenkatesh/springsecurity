package com.springsecurity.springsecurity.java8;

import java.util.stream.IntStream;

public class FiboniseUsingF {
	//Which is the Fibonacci formula: F(n) = F(n-1) + F(n-2)
	public static void main(String[] args) {

		        int n = 10;
		        int[] fib = new int[n];
		        fib[0] = 0;
		        fib[1] = 1;

		        IntStream.range(2, n).forEach(i -> fib[i] = fib[i - 1] + fib[i - 2]);

		        // Print the series
		        IntStream.of(fib).forEach(System.out::println);
		    }
		
	
}
