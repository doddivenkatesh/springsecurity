package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReverseAnIntegerArra {

	public static void main(String[] args) {
		int[] array = new int[] {5, 1, 7, 3, 9, 6};
		int [] reverse=IntStream.range(1, array.length).map(i-> array.length-i).toArray();
		Stream.of(array).sorted().forEach(System.out :: println);
		System.out.println(Arrays.toString(reverse));
	}
}
