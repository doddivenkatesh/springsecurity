package com.springsecurity.springsecurity.java7;

import java.util.ArrayList;
//https://youtu.be/m6YI-FoxMec?si=x_jQ5axoZPP7RUpO
public class FindSubArrayWithGivenSum {



	    // Function to find a continuous sub-array which adds up to
	    // a given number.
	    static ArrayList<Integer> subarraySum(int[] arr, int target) {
	        ArrayList<Integer> res = new ArrayList<>();
	        int n = arr.length;

	        // Pick a starting point for a subarray
	        for (int s = 0; s < n; s++) {
	            int curr = 0;

	            // Consider all ending points
	            // for the picked starting point
	            for (int e = s; e < n; e++) {
	                curr += arr[e];
	                if (curr == target) {
	                    res.add(s + 1);
	                    res.add(e + 1);
	                    return res;
	                }
	            }
	        }
	        // If no subarray is found
	        res.add(-1);
	        return res;
	    }

	    public static void main(String[] args) {
	        int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
	        int target = 23;
	        ArrayList<Integer> res = subarraySum(arr, target);

	        for (int ele : res)
	            System.out.print(ele + " ");
	    }
	

}
