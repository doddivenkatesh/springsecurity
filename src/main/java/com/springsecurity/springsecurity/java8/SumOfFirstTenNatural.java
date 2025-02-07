package com.springsecurity.springsecurity.java8;

import java.util.stream.IntStream;

public class SumOfFirstTenNatural {

	public static void main(String[] args) {
		
		int sum = IntStream.range(1, 10).sum();
		System.out.println(sum);
	}
}
