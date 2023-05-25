package com.example.zoo.application;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.List;

import com.example.zoo.domain.Cat;
import com.example.zoo.domain.Fish;
import com.example.zoo.domain.Spider;

public class Exercise3 {

	public static void main(String[] args) {
		var zooAnimals = List.of(
			new Spider(),
			new Cat(),
			new Fish("Jaws"),
			new Cat("Garfield"),
			new Spider(),
			new Fish("Free Willy"),
			new Spider()
		);
		// filter/map/reduce
		var animalCountsByClass =
		zooAnimals.stream()
		          .map(Object::getClass)
		          .map(Class::getSimpleName)
		          .collect(groupingBy(identity(),counting()));
		System.out.println(animalCountsByClass);
	}

}
