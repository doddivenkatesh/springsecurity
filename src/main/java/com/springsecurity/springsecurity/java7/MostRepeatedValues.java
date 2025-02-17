package com.springsecurity.springsecurity.java7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostRepeatedValues {

	public static void main(String[] args) {
		List<Integer> listOfStrings = Arrays.asList(22,44,55,66,66,554,34);
		int [] arr = {22,44,55,66,66,554,34};
		Map<Integer,Integer> map = new HashMap<>();
		   for(int i=0; i<arr.length; i++) {
			   
			   if(map.containsKey(arr[i])) {
				   map.put(arr[i], map.get(arr[i])+1);
			   }
			   else {
				   map.put(arr[i], 1);
			   }
		   }
		   for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			   System.out.println(entry.getKey() +  " value " + entry.getValue());
		   }
	}
}
