package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoStringsAnargsOrNot {

	public static void main(String[] args) {
		String s1 = "RaceCar";
		String s2 = "CarRace";
		
		s1=Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		s2=Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		if(s1.equals(s2)) {
			System.out.println("these are anargams");
		}
		
		s1=Arrays.stream(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		s2=Arrays.stream(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
	}
}
