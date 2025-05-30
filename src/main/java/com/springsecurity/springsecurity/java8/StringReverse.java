package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.hibernate.sql.results.spi.ListResultsConsumer.UniqueSemantic;



public class StringReverse {

	public static void main(String[] args) {
		
		String str= "venkatesh";
		 int[] array = new int[] {5, 1, 7, 3, 9, 6};
		 String palindrome = "ROTATOR";
		//Stream.of(str.split(" ")).map(e-> new StringBuffer(e).reverse()).forEach(System.out :: println);
		 List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
		 //String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
	   //Arrays.stream(str.split(" ")).map(word -> new StringBuffer(word).reverse()).forEach(System.out :: println);
		 //List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
		 List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
		 // most reapeated element in an array
//		Map<String, Long> groupAndCounting=listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//		         Entry<String, Long> mostRepeated=groupAndCounting.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		           
		//System.out.println(mostRepeated);
		//int [] ar =IntStream.rangeClosed(1, array.length).map(v -> array[array.length-v]).toArray();
		// System.out.println(Arrays.toString(ar));
		//boolean isItPalindrome =IntStream.rangeClosed(0, palindrome.length()/2).noneMatch(i -> palindrome.charAt(i) != palindrome.charAt(palindrome.length()-i-1));
		 //listOfStrings.stream().filter(w -> Character.isDigit(w.charAt(0))).forEach(System.out :: println);
		 Set<Integer> uniqueElements =  new HashSet<Integer> ();
//		 listOfIntegers.stream().filter( f -> !uniqueElements.add(f)).forEach(System.out :: println);
	//	Arrays.stream(inputString.split("")).filter(f -> uniqueElements.add(f)).collect(Collectors.toSet());
		
//		  String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
//	         
//	        Set<String> uniqueChars = new HashSet<>();
//	         
//	        Arrays.stream(inputString.split("")).filter(f -> !uniqueChars.add(f)).forEach(System.out :: println);
	        
	      //  IntStream.rangeClosed(1, 20).filter( f -> f%2!=0).forEach(System.out :: println);
		 int n =10;
		 int arr [] = new int[n];
		 arr[0]=0;
		 arr[1]=1;
		 IntStream.range(2, n).map( m -> arr[m] = arr[m-1] + arr[m-2]).forEach(System.out :: println);
	        
	}
}
