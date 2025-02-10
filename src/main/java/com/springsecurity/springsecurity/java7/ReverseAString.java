package com.springsecurity.springsecurity.java7;

public class ReverseAString {
	public static void main(String[] args) {
		
		
		String s = "venkatesh1223";
		reverseNumber(s);
	}

	 public static String reverseNumber(String s) {
		char [] ch= s.toCharArray();
		 for(int i=ch.length-1; i>=0; i--) {
			 System.out.print(ch[i]);
		 }
		return s;
		
	 }
}
