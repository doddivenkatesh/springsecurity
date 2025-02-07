package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseEachWordOfString {

	public static void main(String[] args) {
		String str = "Java Concept Of The Day";
		String reversWord1 = Arrays.stream(str.split(" ")).map(word -> new StringBuffer(word).reverse())
				.collect(Collectors.joining(" "));
		String reversWord = Stream.of(str.split(" ")).map(word -> new StringBuffer(word).reverse())
				.collect(Collectors.joining(" "));
		System.out.println(reversWord);
		System.out.println(reversWord1);
	}
}
