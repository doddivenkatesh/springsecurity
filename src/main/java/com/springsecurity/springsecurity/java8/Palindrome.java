package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Palindrome {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		String str = "ROTATOR";

		List<String> b = Arrays.stream(str.split(" "))
				.filter(word -> str.equals(new StringBuffer(word).reverse().toString())).collect(Collectors.toList());
		System.out.println(b);
		
        if(b.equals(str)) {
        	System.out.println("its anagram");
        }
		List<String> words = Arrays.asList("radar", "hello", "deified");
		List<String> palindromes = words.stream().filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
				.collect(Collectors.toList());
		
		
		
	}
}
