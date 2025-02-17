package com.springsecurity.springsecurity.java7;

public class CountPairsWithGivenArray {

	public static int countPairs(int arr[],int target) {
		
		int count =0;
		for(int i=0; i<arr.length;i ++) {
			
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]+arr[j] == target) {
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		
		int[] arr = { 1, 5, 7, -1, 5 };
        int target = 6;
         int count=countPairs(arr, target);
         System.out.println(count);
	}
}
