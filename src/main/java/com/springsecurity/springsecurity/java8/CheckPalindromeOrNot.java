package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//https://javaconceptoftheday.com/java-8-interview-sample-coding-questions/
public class CheckPalindromeOrNot {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("radar", "hello", "deified");
		List<String> palindromes = words.stream().filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
				.collect(Collectors.toList());
		System.out.println(palindromes);
	}
}
