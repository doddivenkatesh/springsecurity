package com.springsecurity.springsecurity.java7;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharString {

	public static void main(String[] args) {
		
		String inputString = "Java Concept Of The Day";
		char ch [] =inputString.toCharArray();
			
			String str = " hello venkaetsh ";
			Map<Character,Integer> map = new HashMap<>();
			for(int i=0; i<str.length(); i++){
				int count =1;
				for(int j=0; j<str.length(); j++) {
					if(str.charAt(i) == str.charAt(j) ) {
						map.put(str.charAt(i), count++);
					}
				}
				
			}
			for(Map.Entry<Character, Integer> entryset:map.entrySet()) {
				if(entryset.getValue()>1) {
				System.out.println(entryset.getKey() + " " + entryset.getValue());
			}}
		}
			
		
}
