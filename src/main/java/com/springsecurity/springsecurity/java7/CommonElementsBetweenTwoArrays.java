package com.springsecurity.springsecurity.java7;

import java.util.HashSet;
import java.util.Set;

public class CommonElementsBetweenTwoArrays {

	public static void main(String[] args) {

		int a[] = { 12, 45, 33, 66, 33, 34, 34, 66, 33 };
		int b[] = { 23, 52, 12, 33, 55, 32 };
		String[] arr1 = { "Article", "in", "Geeks", "for", "Geeks" };

		// Create Array 2
		String[] arr2 = { "Geeks", "for", "Geeks" };
		Set<String> set = new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i].equals(arr2[j])) {

					// add common elements
					set.add(arr1[i]);
					break;
				}
			}
		}

		// Common Elements in Arrays
		System.out.println(set.toString());
	}

}
