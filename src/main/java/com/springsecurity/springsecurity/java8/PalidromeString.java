package com.springsecurity.springsecurity.java8;

import java.util.function.Function;
import java.util.stream.Collectors;

public class PalidromeString {

	public static void main(String[] args) {

		String text = "ROTOR";
		System.out.println(hasPalindromePermutation(text));

	}

	static boolean hasPalindromePermutation(String text) {
		long charsWithOddOccurrencesCount = text.chars().boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).values().stream()
				.filter(count -> count % 2 != 0).count();
		return charsWithOddOccurrencesCount <= 1;
	}
}
