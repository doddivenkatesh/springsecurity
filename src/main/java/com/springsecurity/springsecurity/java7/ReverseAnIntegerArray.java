package com.springsecurity.springsecurity.java7;

public class ReverseAnIntegerArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

		int temp = 0;
		for (int i = 0; i < arr.length / 2; i++) {

			System.out.println(arr[arr.length-i-1]);
			temp = arr[i];
			arr[i]= arr[arr.length-i-1];
			arr[arr.length-i-1]= temp;
		}

		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

}
