package com.springsecurity.springsecurity.java7;

import java.util.HashMap;
import java.util.Map;

public class CommonElementsInTwoArrays {

	public static void main(String[] args) {

		int a[] = { 12, 45, 33, 66, 33, 34,34,66,33 };
		int b[] = { 23, 52, 12, 33, 55, 32 };
	
		
		
		String s1 = "venkaatesh";
		Map<Integer,Integer> map1 = new HashMap<>();
		
		for(int i=0; i<a.length; i++) {
			int count = 1;
			
			for(int j=1; j<a.length;j++) {
				if(a[i] == a[j]) {
				       map1.put(a[i],count++);
				}
			}
		}
		for(Map.Entry<Integer, Integer> entry:map1.entrySet()){
			System.out.println( entry.getKey() + " " + entry.getValue());
		}
	}
}
