package com.springsecurity.springsecurity.java7;

import java.util.HashMap;
import java.util.Map;

public class CharcountString {

	public static void main(String[] args) {
		
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
