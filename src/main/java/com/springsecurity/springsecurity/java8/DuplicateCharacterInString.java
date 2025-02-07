package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateCharacterInString {
	public static void main(String[] args) {
		
		String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
		Set<String> uniqueChars  = new HashSet<String>();
		Set<String> duplicateCharacters=Arrays.stream(inputString.split("")).filter(ch -> !uniqueChars.add(ch)).collect(Collectors.toSet());
		System.out.println(duplicateCharacters);
	}

}
