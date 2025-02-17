package com.springsecurity.springsecurity.java7;
//https://youtu.be/T-6NtfyVK64?si=SnkXsVGXxxxeDtVm
public class RowWiseColumnWise {
	// Java program to search an element in row-wise
	// and column-wise sorted matrix
	static boolean matSearch(int[][] mat, int x) {
		int n = mat.length, m = mat[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j] == x)
					return true;
			}
		}

		// If x was not found, return false
		return false;
	}

	public static void main(String[] args) {
		int[][] mat = { { 3, 30, 38 }, { 20, 52, 54 }, { 35, 60, 69 } };
		int x = 35;

		if (matSearch(mat, x))
			System.out.println("true");
		else
			System.out.println("false");
	}

}
