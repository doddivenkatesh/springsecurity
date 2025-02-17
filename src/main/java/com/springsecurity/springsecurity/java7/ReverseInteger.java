package com.springsecurity.springsecurity.java7;

public class ReverseInteger {

	public static void main(String[] args) {
		int[] arr = new int[] { 45, 12, 56, 15, 24, 75, 31, 89 };
		int[] reverseArray = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {

			reverseArray[i] = arr[arr.length - 1 - i];
		}

		for (int num : reverseArray) {
			System.out.print(num + " ");
		}
	}
}
