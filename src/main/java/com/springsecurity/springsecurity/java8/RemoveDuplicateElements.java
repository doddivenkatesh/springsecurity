package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateElements {

	public static void main(String[] args) {
		
		 List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
		// List<String> unique=listOfStrings.stream().distinct().collect(Collectors.toList());
		 //System.out.println(unique);
		 listOfStrings.stream().distinct().forEach(System.out:: println);
		
	}
}
