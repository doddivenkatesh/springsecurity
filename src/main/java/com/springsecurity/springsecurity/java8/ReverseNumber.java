package com.springsecurity.springsecurity.java8;

public class ReverseNumber {

	static int number = 12345;
	static int revese =0;
	public static void main(String[] args) {
		System.out.println("reverse number");
               while(number!=0){
		       int remainder = number%10;
		       revese = revese*10 + remainder;
		       number= number/10;
	       }
		
	}
}
