package com.springsecurity.springsecurity.java7;

import java.util.Arrays;

public class TwoStringAnargams {

	public static void main(String[] args) {
		String s1 = "RaceCar";
		String s2 = "CarRace";
		char ch[] = s1.toCharArray();
		String[] chs = s1.split(" ");
		StringBuffer bf = new StringBuffer();
		bf.append(s1);
		String rev = "";
		/*
		 * for(String s:chs) { System.out.println(s); } System.out.println(ch);
		 * 
		 * for( int i=ch.length-1; i>0; i--) { rev= rev+ch[i]; } if(rev.equals(s1)) {
		 * System.out.println("its palindrome"); }
		 */
		boolean status = true;
		if (s1.length() != s2.length()) {
			status = false;
		} else {
			char[] arrays1 = s1.toCharArray();
			char[] arrays2 = s2.toCharArray();
			Arrays.sort(arrays1);
			Arrays.sort(arrays2);
			status = Arrays.equals(arrays1, arrays2);
		}
		if (status) {
			System.out.println(s1 + " and " + s2 + "are anargams");
		} else {
			System.out.println(s1 + " and " + s2 + "are not anargams");
		}

	}

}
