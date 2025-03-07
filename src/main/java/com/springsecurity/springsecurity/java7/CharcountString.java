package com.springsecurity.springsecurity.java7;

import java.util.HashMap;
import java.util.Map;

public class CharcountString {

	public static void main(String[] args) {
		/*
		 * String s = "venkaatesh";
		Map<Character,Integer> map = new HashMap<>();
		
		char ch [] =s.toCharArray();
		for(int i=0; i<ch.length; i++) {
			int count = 1;
			
			for(int j=0; j<ch.length;j++) {
				if(ch[i] == ch[j]) {
				       map.put(ch[i],count++);
				}
			}
		}
		for(Map.Entry<Character, Integer> entry:map.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue());
		} 
		
		
		
		
		
        String s = "Programming";
        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);           // Update count
        }

        System.out.println("Character Occurrences:");
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
		 * */
		String s = "venkaatesh";
		Map<Character,Integer> map = new HashMap<>();
		
		char ch [] =s.toCharArray();
		for(int i=0; i<ch.length; i++) {
			int count = 1;
			
			for(int j=0; j<ch.length;j++) {
				if(ch[i] == ch[j]) {
				       map.put(ch[i],count++);
				}
			}
		}
		for(Map.Entry<Character, Integer> entry:map.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
