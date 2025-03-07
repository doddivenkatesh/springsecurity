package com.springsecurity.springsecurity.java7;

import java.util.Arrays;
import java.util.List;

public class SecondHightest {

	public static void main(String[] args) {

		int b[] = { 44, 66, 99, 77, 33, 22, 55 };

		int max = 0;
		int secondHighest = 0;

		for (int i = 0; i < b.length; i++) {

			if (b[i] > max) {
				max = b[i];

			}
		}

		for (int i = 0; i < b.length; i++) {
			if (b[i] > secondHighest && b[i] != max) {
				secondHighest = b[i];
			}
		}
		System.out.println("the second highest is " +secondHighest);
		System.out.println(" the max number is " +max);
	}
}
