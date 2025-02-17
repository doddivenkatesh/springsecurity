package com.springsecurity.springsecurity.java7;

public class SortAnArray {

	public static void main(String[] args) {
		
		int[] sort = { 23, 54, 53, 25, 1, 57, 3, 5 };

		for (int i = 0; i < sort.length; i++) {

			for (int j = i; j < sort.length; j++) {

				if (sort[i] > sort[j]) {
					int temp = sort[i];
					sort[i] = sort[j];
					sort[j] = temp;
				}
			}

		}
		for (int arr : sort) {
			System.out.print(arr + " ");
		}
	
	}
}
