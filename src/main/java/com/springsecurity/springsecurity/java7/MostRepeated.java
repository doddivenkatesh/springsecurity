package com.springsecurity.springsecurity.java7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostRepeated {

	public static void main(String[] args) {

		
		int max = 0;
		String s = null;
		String[] arr = { "Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil" };
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		for (Map.Entry<String, Integer> str : map.entrySet()) {
			if (str.getValue() > max) {
				max = str.getValue();
				System.out.println(str.getKey() + max);
			}

		}
	}
}