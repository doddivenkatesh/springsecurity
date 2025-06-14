package com.springsecurity.springsecurity.java8;

import static org.mockito.ArgumentMatchers.intThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UseCases {

	public static void main(String[] args) {
		// how do you get last element of an array
		// List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four",
		// "Five", "Six");

//		String s=listOfStrings.stream().skip(listOfStrings.size()-1).findFirst().get();
//		System.out.println(s);
		// find Ten oDD Numbers
		// IntStream.rangeClosed(1, 10).filter(f -> f%2!=0).forEach(System.out ::
		// println);
		// finosis serires
		// formula f[i]= f[i-1] + f[i+2]

		// fib[2] = fib[1] + fib[0] = 1 + 0 = 1
		// fib[3] = fib[2] + fib[1] = 1 + 1 = 2
		// fib[4] = fib[3] + fib[2] = 2 + 1 = 3
		// fib[9] = fib[8] + fib[7] = 21 + 13 = 34

//		int n=10;
//		int arr [] = new int[n];
//		arr[0]=0;
//		arr[1]=1;
//		IntStream.range(2,n).forEach(i -> arr[i] = arr[i-1] + arr[i-2]);
//		IntStream.of(arr).forEach(System.out :: println);
		// Find first non-repeated character in a string?
		//String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
//		Map<String,Long> groupchars=Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap:: new, Collectors.counting()));
//		String s=groupchars.entrySet().stream().filter(i -> i.getValue() ==1).map(v -> v.getKey()).findFirst().get();
//		System.out.println(s);

		// find first repeated character
//		Map<String,Long> grouping=Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap:: new,Collectors.counting()));
//		String str=grouping.entrySet().stream().filter(i -> i.getValue()>1).map(m -> m.getKey()).findFirst().get();
//		System.out.println(str);

		// find the duplicate characters in string
		// Set<String> uniqueElements = new HashSet<String>();
//	    Set<String> s=Arrays.stream(inputString.split("")).filter(f -> !uniqueElements.add(f)).collect(Collectors.toSet());
//	    System.out.println(s);
		// extract the duplicate elements from an array
		// List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333,
		// 777, 222);
		// Set<Integer> uniqueElements = new HashSet<>();
		// Set<Integer> ss = listOfIntegers.stream().filter(f ->
		// !uniqueElements.add(f)).collect(Collectors.toSet());
		// System.out.println(ss);

//	        Set<Integer> duplicateElements = listOfIntegers.stream().filter(i -> ! uniqueElements.add(i)).collect(Collectors.toSet());
////	         listOfIntegers.stream().filter(f -> uniqueElements.add(f)).collect(Collectors.toSet());
////	        System.out.println(duplicateElements);

//		 List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
//		 listOfStrings.stream().filter(f -> Character.isDigit(f.charAt(0))).forEach(System.out :: println);
		// palindrome or not
		String str = "ROTATOR";

//		 boolean IsiPalindrome =IntStream.range(0, str.length()/2).noneMatch( f -> str.charAt(f) != str.charAt(str.length()-f-1));
//		 if(IsiPalindrome) {
//			 System.out.println("its palindrome");
//		 }else {
//			 System.out.println("no its not palindrome");
//		 }

//		 List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
//		 Map<String,Long> grouping=listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//		String mostRepeat=grouping.entrySet().stream().max(Map.Entry.comparingByValue()).map(m -> m.getKey()).get();
//		System.out.println(mostRepeat);

//		  int[] array = new int[] {5, 1, 7, 3, 9, 6};
//		  int [] rev=IntStream.rangeClosed(1, array.length).map(v -> array[array.length-v]).toArray();	
//		  System.out.println(Arrays.toString(rev));

//		  List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
//	         
//	        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
//	        
//	      list1.stream().filter(list2 :: contains).forEach(System.out :: println);

//		    List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
//		    
//	    listOfStrings.stream().sorted(Comparator.comparing(String :: length)).forEach(System.out :: println);

//		int i = 15623;
//		int n = Arrays.stream(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
//		System.out.println(n);
//		String s1 = "RaceCar";
//		String s2 = "CarRace";
//
//		s1=Arrays.stream(s1.split("")).map(String :: toUpperCase).sorted().collect(Collectors.joining());
//		 
//		s2=Arrays.stream(s2.split("")).map(String ::toUpperCase).sorted().collect(Collectors.joining());
//		if(s1.equals(s2)) {
//			System.out.println("two strings are anaragm"
//					+ "");
//		}
		
//		 List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
//		 listOfIntegers.stream().sorted().limit(3).forEach(System.out::println);
//		 listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out :: println );

//	        int[] a = new int[] {4, 2, 5, 1};
//	         
//	        int[] b = new int[] {8, 1, 9, 5};
//	        
//	        IntStream.concat(Arrays.stream(a), Arrays.stream(b)).forEach(System.out ::println);
//	        
//	        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
//	         
//	        listOfIntegers.stream().max(Comparator.naturalOrder()).get();
		
		 String inputString = "Java Concept Of The Day";
		 
		 Map<String, Long> s=Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		 System.out.println(s);
	
	}

}
