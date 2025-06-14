package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.antlr.v4.runtime.IntStream;


public class StringRepresentaion {
	public static void main(String[] args) {
		//To convert a String value into a Collection in Java, it depends on the structure of your string and what kind of collection you want (e.g., List, Set, etc.).

		//Here are a few common examples:
		//1. Comma-separated String to List
		String input = "apple,banana,orange";
		List<String> list = Arrays.asList(input.split(","));
		System.out.println("1. Comma-separated String to List " + list);
		String input1 = "apple,banana,orange,apple";
		Set<String> set = new HashSet<>(Arrays.asList(input1.split(",")));
		System.out.println("2. Comma-separated String to Set (to remove duplicates " + list);
		
		String input2 = "apple;banana;orange";
		List<String> list1 = Arrays.asList(input2.split(";"));
		System.out.println("3. String with custom delimiter (e.g., ;) " + list1);
		
		
		String input3 = "a,b,c";
		List<String> list3 = Arrays.stream(input3.split(","))
		                          .map(String::trim)
		                          .collect(Collectors.toList());
		System.out.println(" 4. Using Collectors.toList() (for streams) " + list3);
		
		String word = "radar";
		java.util.stream.IntStream codePointStream = word.chars();
		System.out.println("3. Stream of Code Points (as IntStream)"+codePointStream);
		
		Stream<Character> characterStream = word.chars() // IntStream
                .mapToObj(c -> (char) c);
		System.out.println("1. Stream of Characters (as Character)"+characterStream);
		Stream<String> stringCharStream = Arrays.stream(word.split(""));
		System.out.println("2. Stream of Characters (as String) "+ stringCharStream);
	}
}
