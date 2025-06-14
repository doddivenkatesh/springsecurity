package com.springsecurity.springsecurity.java7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Shifiting {

	
	public static void main(String[] args) {
		
		List<Integer> li=Arrays.asList(10,20,30);
		
		//int arr [] = {10,20,30};
		
		//using java 8
//		  List<Integer> input = Arrays.asList(1, 2, 4, 6);
//
//	        int max = Collections.max(input);
//System.out.println(max);
//	        List<Integer> missing = IntStream.rangeClosed(1, max)
//	                .filter(i -> !input.contains(i))
//	                .boxed()
//	                .collect(Collectors.toList());
//
//	        System.out.println("Missing elements: " + missing);
		
		
	//	using java 7

//		        List<Integer> input = Arrays.asList(1, 2, 4, 6);
//		        List<Integer> missing = new ArrayList<>();
//
//		        int max = Collections.max(input);
//		        for (int i = 1; i <= max; i++) {
//		            if (!input.contains(i)) {
//		                missing.add(i);
//		            }
//		        }
//
//		        System.out.println("Missing elements: " + missing);
//		    }
		
		
	        int[] arr = {1, 2, 4, 5, 6}; // missing number: 3
	        int n = 6; // expected total count from 1 to 6

	        int expectedSum = n * (n + 1) / 2;
	        int actualSum = 0;

	        for (int i = 0; i < arr.length; i++) {
	            actualSum += arr[i];
	        }

	        int missingNumber = expectedSum - actualSum;

	        System.out.println("Missing number: " + missingNumber);
	    }
}
