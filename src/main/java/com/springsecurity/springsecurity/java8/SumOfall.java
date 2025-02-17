package com.springsecurity.springsecurity.java8;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfall {

	public static void main(String[] args) {
		int i = 15625;
		Integer sumOfDigits=Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer :: parseInt));
         
	        System.out.println(sumOfDigits);
	    }
	

	
}
