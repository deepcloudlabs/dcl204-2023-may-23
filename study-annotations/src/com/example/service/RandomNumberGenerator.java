package com.example.service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import com.example.util.RandomNumber;

public class RandomNumberGenerator {
	public void generate(Object o) throws IllegalArgumentException, IllegalAccessException {
		var clazz = o.getClass();
		for (var field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(RandomNumber.class)) {
				var randomNumber = field.getAnnotation(RandomNumber.class);
				var min = randomNumber.min();
				var max = randomNumber.max();
				var size = randomNumber.size();
				var sorted = randomNumber.sorted();
				var distinct = randomNumber.distinct();
				var intStream = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(min, max+1));
				if (distinct)
					intStream = intStream.distinct();
				intStream = intStream.limit(size);
				if (sorted)
					intStream = intStream.sorted();
				var numbers = intStream.boxed().toList();
				field.setAccessible(true);
				field.set(o, numbers);		               
				field.setAccessible(false);
			}
		}
	}
}
