package com.springsecurity.springsecurity.java7;

public class SumOfElements {
//missing element in array
	// rotation array elements
	public static void main(String[] args) {
	    int[] arr = { 12, 35, 1, 10, 34, 1 };
	    int sum =0;
	    for(int i=0; i<arr.length; i++) {
	    	sum= sum+arr[i];
	    }
	    System.out.println(sum);
	}
}
