package com.ezycoding.psa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {

	static boolean isAnagram(String w1, String w2) {

		if (w1.length() != w2.length()) {
			return false;
		}

		char[] chaw1 = w1.toCharArray();
		char[] chaw2 = w2.toCharArray();

		Arrays.sort(chaw1);
		Arrays.sort(chaw2);

		String sortedW1 = new String(chaw1);
		String sortedW2 = new String(chaw2);

		return sortedW1.equals(sortedW2);
	}

	static boolean isAnagram2(String w1, String w2) {
		if (w1.length() != w2.length()) {
			return false;
		}

		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();

		int len = w1.length();

		for (int i = 0; i < len; i++) {
			char chw1 = w1.charAt(i);
			if (map1.containsKey(chw1)) {
				map1.put(chw1, map1.get(chw1) + 1);
			} else {
				map1.put(chw1, 1);
			}

			char chw2 = w2.charAt(i);
			if (map2.containsKey(chw2)) {
				map2.put(chw2, map2.get(chw2) + 1);
			} else {
				map2.put(chw2, 1);
			}

		}
		// System.out.println(map1);
		// System.out.println(map2);
		return map1.equals(map2);
	}

	static boolean isAnagram3(String w1, String w2) {
		
		if (w1.length() != w2.length()) {
			return false;
		}
		
		List<String> list1 = Arrays.asList(w1.split(""));
		List<String> list2 = Arrays.asList(w2.split(""));
		
		Map<String, Long> map1 = list1
				.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		Map<String, Long> map2 = list2
				.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map1);
		System.out.println(map2);
		
		return map1.equals(map2);
	}

	public static void main(String[] args) {
		System.out.println(isAnagram3("robotics", "cstiboro"));
	}
}
