package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListOfStringsortAccordingTolength {
	
	public static void main(String[] args) {
		
		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
		listOfStrings.stream().sorted(Comparator.comparing(String:: length)).forEach(System.out :: println);
	}

}
