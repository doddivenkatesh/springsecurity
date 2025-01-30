package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequecyOfElement {

	public static void main(String[] args) {
		String arr[] = {"Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil"};
		/* List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
		 Map<String, Long> elements=stationeryList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		 System.out.println(elements);
		 */
		//
		 Map<String,Long> counting=Arrays.asList(arr).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		 System.out.println(counting);
	
	}
}
