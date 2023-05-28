package com.example.collections;

import java.util.Set;
import java.util.TreeSet;

public class StudySet {

	public static void main(String[] args) {
		// Set
		// 1. Unique ✔
		// 2. UnOrdered ✔ 
		Set<Integer> numbers = new TreeSet<>((u, v) -> v - u);
		numbers.add(42);
		numbers.add(16);
		numbers.add(42);
		numbers.add(15);
		numbers.add(23);
		numbers.add(4);
		numbers.add(42);
		numbers.add(8);
		System.out.println(numbers);
		for (var number : numbers) {
			System.out.println(number);
		}
		numbers.forEach(number -> System.out.println(number));
		numbers.forEach(System.out::println);
	}

}
