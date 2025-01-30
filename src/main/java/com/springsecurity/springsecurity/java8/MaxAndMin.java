package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxAndMin {

	public static void main(String[] args) {

		 List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		int max= listOfIntegers.stream().max(Comparator.naturalOrder()).get();
		   System.out.println("Maximum Element : "+max);
		 int min =listOfIntegers.stream().min(Comparator.naturalOrder()).get();
		 System.out.println("Minimum Element : "+min);
		 
	}

}
