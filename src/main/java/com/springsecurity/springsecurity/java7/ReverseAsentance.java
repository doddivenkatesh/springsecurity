package com.springsecurity.springsecurity.java7;

public class ReverseAsentance {
	public static void main(String[] args) {
		
		String str = "Java Concept Of The Day";
		String[] st=str.split(" ");
		String rev ="";
		for(int i=st.length-1; i>=0; i--) {
			
			rev= rev+st[i];
			
		}
		System.out.println(rev);
	}

}
