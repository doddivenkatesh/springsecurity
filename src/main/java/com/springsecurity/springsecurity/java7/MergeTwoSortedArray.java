package com.springsecurity.springsecurity.java7;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8,4,6,4};

		int[] arr3 = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;
		while (i < arr1.length) {
			arr3[k++] = arr1[i++];
		}
		while (j < arr2.length) {
			arr3[k++] = arr2[j++];
		}
		Arrays.sort(arr3);
		
		for(int num:arr3) {
			System.out.print(num + " ");
		}
	}
}