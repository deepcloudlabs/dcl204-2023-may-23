package com.example.exercises;

import java.util.Arrays;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class Exercise01 {

	public static void main(String[] args) {
		int number = 42; // scalar variable
		Integer numbers[] = { 4, 8, 15, 16, 23, 42 };
		System.out.println("# of elements in the array : %d".formatted(numbers.length));
		System.out.println(numbers[0]);
		System.out.println(numbers[6-1]);
		// External Loop #1
		for (int i=0;i<numbers.length;++i) {
			System.out.println("numbers[%d]: %d".formatted(i,numbers[i]));
		}
		// External Loop #2
		for (int value : numbers) {
			System.out.println(value);			
		}
		// Internal Loop #3 -> Functional Programming		
		Arrays.asList(numbers).forEach(System.out::println);
		Stream.of(numbers).forEach(System.out::println);
	}

}
