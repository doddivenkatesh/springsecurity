package com.springsecurity.springsecurity.java8;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfAllDigitsOfNumber {

	public static void main(String[] args) {
		int i = 15623;
		int sumOfDigits = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(sumOfDigits);
		Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
		
	}
}
