package com.springsecurity.springsecurity.java7;

public class ReverseWord {
	
	public static void main(String[] args) {
		 String str = "Java Concept Of The Day";
		String arr[] =str.split(" ");
	    String [] reverse = new String[arr.length];
		for(int i=0; i<arr.length; i++) {
			reverse [i]= arr[arr.length-1-i];
		}
		
		for(String st:reverse) {
			System.out.print(st + " ");
		}
	}

}
