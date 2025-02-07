package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeperateOddAndEvenNumbers {

	public static void main(String[] args) {

		List<Integer> listofIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
		Map<Boolean,List<Integer>> map=listofIntegers.stream().collect(Collectors.partitioningBy(e -> e%2==0));
		
		
		for(Map.Entry<Boolean,List<Integer>> entry: map.entrySet()) {
			
			if(entry.getKey()) {
				System.out.println("its a even number");
			}else {
				System.out.println("not a even number");
			}
			//System.out.println(	entry.getKey() + "" + entry.getValue());
			List<Integer> list = entry.getValue();
			for(int li:list) {
				System.out.println(li);
			}
		} 
		
		
		
		
		Map<Integer, Integer> map1 = new HashMap<>();
		map1.put(1, 100);
		map1.put(2, 200);
		map1.put(3, 300);
		for(Map.Entry<Integer, Integer> entry:map1.entrySet()) {
			System.out.println( entry.getKey() + " " + entry.getValue());
		}
		
		
	}

}
