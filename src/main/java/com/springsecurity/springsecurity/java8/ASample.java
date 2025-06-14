package com.springsecurity.springsecurity.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://neesri.medium.com/java-program-using-java-8-0ae0ca33b511
//https://www.google.com/search?q=find+the+highest+salary+in+java+8&rlz=1C1CHBD_enIN1143IN1143&oq=find+the+highest+salary+in+java+8+&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIICAEQABgWGB4yCAgCEAAYFhgeMggIAxAAGBYYHjIICAQQABgWGB4yCAgFEAAYFhgeMggIBhAAGBYYHjIICAcQABgWGB4yDQgIEAAYhgMYgAQYigUyDQgJEAAYhgMYgAQYigXSAQkxMDg3MmowajeoAgCwAgA&sourceid=chrome&ie=UTF-8
public class ASample {

	public static void main(String[] args) {
	    List<String> words=	Arrays.asList("radar","hello","defined","cac");
	    String word= "abc";
	    String[] str=word.split("");
	    @SuppressWarnings("unlikely-arg-type")
		List<String> ss=Arrays.stream(str).filter(w -> w.equals(new StringBuffer(w).reverse())).collect(Collectors.toList());
	    System.out.println(ss);
	    //Stream<String> stringCharStream = Arrays.stream(word.split(""));
	   // Arrays.stream(word.split("")).filter(word -> word.equals(new StringBuffer(word).reverse().toString()).collect(Collectors.toList());\
	   //List<String> s= words.stream().filter(word -> word.equals(new StringBuffer(word).reverse().toString())).collect(Collectors.toList());
	}
}