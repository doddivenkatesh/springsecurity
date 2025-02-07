package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrintThreeMaxAndThreeMin {

	public static void main(String[] args) {
		   List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		   List<Integer> minThree=listOfIntegers.stream().sorted().limit(3).collect(Collectors.toList());
		   System.out.println(minThree);
		   List<Integer> maxthree = listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
		   System.out.println(maxthree);
	}
}
