package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElementsAnArray {
	public static void main(String[] args) {
		
		
		List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
		Set<Integer> uniqueElements = new HashSet<Integer>();
		Set<Integer> duplicateElements=listOfIntegers.stream().filter(e -> !uniqueElements.add(e)).collect(Collectors.toSet());
		System.out.println(duplicateElements);
	}

}
