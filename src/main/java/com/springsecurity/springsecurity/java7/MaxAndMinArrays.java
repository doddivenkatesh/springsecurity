package com.springsecurity.springsecurity.java7;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MaxAndMinArrays {

	public static void main(String[] args) {
		
		/*int[] arr = {2,9,6,5,8,1};
		
		int i,max,min;
		
	   Arrays.sort(arr);
	   for(int j=0; j<arr.length; j++) {
		   
		   System.out.println(arr[j]);
	   }*/
		
		
		
		
		
	
		int[] arr = {2,9,6,5,8,1};
		int max=arr[0]; 
		int min= arr[0];
		for(int i=0; i<arr.length; i++) {
			
			if(arr[i]>max) {
				max=arr[i];
			}
			else if(arr[i]<min) {
				min=arr[i];
			}
		}
		System.out.println("the maximum value is " + max);
		System.out.println("the minimum value is " + min);
	}

}