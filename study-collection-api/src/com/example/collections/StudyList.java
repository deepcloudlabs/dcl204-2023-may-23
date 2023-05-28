package com.example.collections;

import java.util.LinkedList;
import java.util.List;

public class StudyList {

	public static void main(String[] args) {
		// List
		// 1. Allows duplicate ✔
		// 2. Ordered ✔ => sortable
		List<Integer> numbers = new LinkedList<>();
		numbers.add(42);
		numbers.add(16);
		numbers.add(42);
		numbers.add(15);
		numbers.add(23);
		numbers.add(4);
		numbers.add(42);
		numbers.add(8);
		System.out.println(numbers);
		System.out.println(numbers.get(0));
		System.out.println(numbers.get(3));
		System.out.println(numbers.get(5));
		numbers.add(4, 42);
		System.out.println(numbers);
		numbers.sort((u, v) -> u - v);
		System.out.println(numbers);
		numbers.sort((u, v) -> v - u);
		System.out.println(numbers);
		for (var number : numbers) {
			System.out.println(number);
		}
		numbers.forEach(number -> System.out.println(number));
		numbers.forEach(System.out::println);
	}

}
