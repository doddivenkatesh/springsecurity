package com.springsecurity.springsecurity.java7;

import java.util.Arrays;

public class NegetiveToBeginning {

	static int[] move(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {

            // If negative number is present
            // swap it with arr[j]
            if (arr[i] < 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int[] ans = move(arr);

        for (int num : ans) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
	
}
