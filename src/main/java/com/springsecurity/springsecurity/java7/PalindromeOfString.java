package com.springsecurity.springsecurity.java7;

public class PalindromeOfString {
	public static void main(String[] args) {

		String palindrome = "civic";
		char ch[] = palindrome.toCharArray();
		String rev = "";
		System.out.println(rev);
		for (int i = ch.length - 1; i >= 0; i--) {

			rev = rev + ch[i];
		}
		System.out.println(rev);
		if (palindrome.equals(rev)) {
			System.out.println("its palindrome");
		}

		String str = "Radar", reverseStr = "";

		int strLength = str.length();

		for (int i = (strLength - 1); i >= 0; --i) {
			reverseStr = reverseStr + str.charAt(i);
		}

		if (str.toLowerCase().equals(reverseStr.toLowerCase())) {
			System.out.println(str + " is a Palindrome String.");
		} else {
			System.out.println(str + " is not a Palindrome String.");
		}
	}
}