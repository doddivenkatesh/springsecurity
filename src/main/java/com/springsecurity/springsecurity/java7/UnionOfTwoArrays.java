package com.springsecurity.springsecurity.java7;

import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoArrays {

	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 4, 5 };
		int arr2[] = { 1, 2, 3, 6 };
		int count = 0;
		Set<Integer> setof = new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			setof.add(arr1[i]);
		}
		for (int j = 0; j < arr2.length; j++) {
			setof.add(arr2[j]);
		}
		System.out.println(setof);
		System.out.println(setof.size());
	}
}
